package org.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.assignment.constants.FoodConstant;
import org.assignment.dao.PeopleDAO;
import org.assignment.entity.People;
import org.assignment.view.PeoplePOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleDAO peopleDAO;
	
	@Override
	public People getPeopleById(int peopleId) {
		People obj = peopleDAO.getPeopleById(peopleId);
		return obj;
	}	
	@Override
	public List<People> getAllPeople(){
		return peopleDAO.getAllPeople();
	}
	@Override
	public synchronized boolean addPeople(People people){
		System.out.println("addPeople Service :" + people);
		if (peopleDAO.peopleExists(people.getName(), people.getEmail())) {
        	System.out.println("if :" + people);
            return true;
        } else {
            peopleDAO.addPeople(people);
            System.out.println("else :" + people);
            return true;
        }
	}
	
	@Override
	public synchronized boolean addPeople(PeoplePOJO objpeople){
		People people = new People(objpeople);
		return addPeople(people);
	}
	@Override
	public synchronized boolean addFriends(PeoplePOJO objPeople){
		peopleDAO.addFriends(objPeople);
		return true;
	}
		
	@Override
	public void updatePeople(People people) {
		peopleDAO.updatePeople(people);
	}
	
	@Override
	public void deletePeople(int peopleId) {
		peopleDAO.deletePeople(peopleId);
	}
	
	@Override
	public List<String> getAllEmployeeList(String name){
		return peopleDAO.getAllEmployeeList(name);	
	}
	
	@Override
	public List<Object> getCommonFriends(int idOne, int idTwo, String eyeColor) {
		return peopleDAO.getCommonFriends(idOne, idTwo, eyeColor);
	}
	
	@Override
	public List<String> getFavouriteFood(People people){
		return peopleDAO.getFavouriteFood(people);
	}
	
	@Override
	public List<String> getFruits(List<String> foodList){
		List<String> fruitsList = new ArrayList<String>(FoodConstant.fruits);
		fruitsList.retainAll(foodList);
		return fruitsList;
	}
	
	@Override
	public List<String> getVegetables(List<String> foodList){
		List<String> vegetableList = new ArrayList<String>(FoodConstant.vegetables);
		vegetableList.retainAll(foodList);
		return vegetableList;
	}
}
