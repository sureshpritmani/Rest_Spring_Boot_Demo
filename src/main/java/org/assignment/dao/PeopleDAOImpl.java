package org.assignment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.assignment.entity.Food;
import org.assignment.entity.People;
import org.assignment.entity.TagElement;
import org.assignment.view.FriendPOJO;
import org.assignment.view.PeoplePOJO;

@Transactional
@Repository
public class PeopleDAOImpl implements PeopleDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	@Override
	public People getPeopleById(int peopleId) {
		return entityManager.find(People.class, peopleId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<People> getAllPeople() {
		String hql = "FROM People as p ORDER BY p.index";
		return (List<People>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public void addPeople(People people) {
		System.out.println("Add Method DAO :" + people);
		entityManager.persist(people);
	}
	
	@Override
	public void updatePeople(People people) {
		People peopleObj = getPeopleById(people.getIndex());
		people.setIndex(peopleObj.getIndex());
		people.setName(peopleObj.getName());
		entityManager.flush();
	}
	
	@Override
	public void addFriends(PeoplePOJO objPeople) {
		
		People people = entityManager.find(People.class, objPeople.getIndex());
		for(FriendPOJO tempFriend : objPeople.getFriends()) {
			people.getFriends().add(entityManager.find(People.class, tempFriend.getIndex()));
		}
		
		List<String> tagElementList = objPeople.getTags();
		String findTagHQL = "FROM TagElement as t WHERE t.tags = :tags";
		TagElement newTag = null;
		for(String tagElemnt : tagElementList) {
			List<TagElement> tagLst = entityManager.createQuery(findTagHQL).setParameter("tags", tagElemnt).getResultList();
			if(null != tagLst && tagLst.size() > 0) {
				people.getTags().add(tagLst.get(0));
			} else {
				newTag = new TagElement();
				newTag.setTags(tagElemnt);
				people.getTags().add(newTag);
			}
		}
		
		List<String> foodList = objPeople.getFavouriteFood();
		String findFoodHQL = "FROM Food as f WHERE f.foodName = :foodName";
		Food newFood = null;
		for(String foodElemnt : foodList) {
			List<Food> foodLst = entityManager.createQuery(findFoodHQL).setParameter("foodName", foodElemnt).getResultList();
			if(null != foodLst && foodLst.size() > 0) {
				people.getFavouriteFood().add(foodLst.get(0));
			} else {
				newFood = new Food();
				newFood.setFoodName(foodElemnt);
				people.getFavouriteFood().add(newFood);
			}
		}
		
		entityManager.persist(people);
		entityManager.flush();
		
	}
	
	@Override
	public void deletePeople(int PeopleId) {
		entityManager.remove(getPeopleById(PeopleId));
	}
	
	@Override
	public boolean peopleExists(String name, String email) {
		String hql = "FROM People as p WHERE p.name = :name and p.email = :email";
		int count = entityManager.createQuery(hql).setParameter("name", name).setParameter("email", email)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public List<String> getAllEmployeeList(String name){
		return (List<String>) (entityManager.createQuery("select p.name from People p, Company c where p.companyId = c.id and c.company = :name")
				.setParameter("name", name)
				.getResultList());
	}
	
	@Override
	public List<Object> getCommonFriends(int idOne, int idTwo, String eyeColor) {
		String query = "select ppl.name from people as ppl where ppl.idx in (select FriendA.friend_id from"
						+ "(select pf.friend_id from people_friends as pf, people as p where pf.idx = p.idx and p.idx = :idOne) as FriendA," 
						+ "(select pf.friend_id from people_friends as pf, people as p where pf.idx = p.idx and p.idx = :idTwo) as FriendB"
						+ " where FriendA.friend_id = FriendB.friend_id) and ppl.has_died = false and ppl.eye_color = :eyeColor ";
		return (List<Object>) (entityManager.createNativeQuery(query)
				.setParameter("idOne", idOne)
				.setParameter("idTwo", idTwo)
				.setParameter("eyeColor", eyeColor)
				.getResultList());
	}
	
	@Override
	public List<String> getFavouriteFood(People people){
		List <Food> foodList = new ArrayList<Food>(people.getFavouriteFood());
		List <String> foodNameList = new ArrayList<String>();
		for(Food food : foodList) {
			foodNameList.add(food.getFoodName());
		}
		return foodNameList;
	}

} 
