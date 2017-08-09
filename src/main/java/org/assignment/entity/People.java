package org.assignment.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.assignment.view.PeoplePOJO;

@Entity
@Table(name="people")
public class People implements Serializable {
	
	public People() {
		
	}
	
	public People (PeoplePOJO objPeople) {
		this.about = objPeople.getAbout();
		this.address = objPeople.getAddress();
		this.age = objPeople.getAge();
		this.balance = objPeople.getBalance();
		this.companyId = objPeople.getCompany_id();
		this.email = objPeople.getEmail();
		this.eyeColor = objPeople.getEyeColor();
		this.gender = objPeople.getGender();
		this.greeting = objPeople.getGreeting();
		this.guid = objPeople.getGuid();
		this.hasDied = objPeople.isHas_died();
		this.id = objPeople.getId();
		this.index = objPeople.getIndex();
		this.name = objPeople.getName();
		this.phone = objPeople.getPhone();
		this.picture = objPeople.getPicture();
		this.registered = objPeople.getRegistered();
		
//		TagElement tagElement = null;
//		Set<TagElement> tagElements = new HashSet<TagElement>();
//		for(String tags : objPeople.getTags()) {
//			tagElement = new TagElement();
//			tagElement.setTags(tags);
//			tagElements.add(tagElement);
//		}
//		this.setTags(tagElements);
//		
//		Food food = null;
//		Set<Food> favouriteFoodList = new HashSet<Food>();
//		for(String foodName : objPeople.getFavouriteFood()) {
//			food = new Food();
//			food.setFoodName(foodName);;
//			favouriteFoodList.add(food);
//		}
//		this.setFavouriteFood(favouriteFoodList);
		System.out.println("People Constructor called with tags.........");
		
		
	}
	
	@Column(name="id")
	private String id;

	@Id
	@Column(name="idx")
	private int index;
	
	@Column(name="guid")
	private String guid;
	
	@Column(name="has_died")
	private boolean hasDied;
	
	@Column(name="balance")
	private String balance;
	
	@Column(name="picture")
	private String picture;

	@Column(name="age")
	private int age;

	@Column(name="eyeColor")
	private String eyeColor;

	@Column(name="name")
	private String name;

	@Column(name="gender")
	private String gender;

	@Column(name="companyId")
	private int companyId;

	@Column(name="email")
	private String email;

	@Column(name="phone")
	private String phone;

	@Column(name="address")
	private String address;

	@Column(name="about", length=600 )
	private String about;

	@Column(name="registered")
	private String registered;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<TagElement> tags;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Food> favouriteFood;

	@Column(name="greeting")
	private String greeting;

//	@ManyToMany(cascade={CascadeType.ALL})
//	@JoinTable(name="FRIENDS_WITH",
//		joinColumns={@JoinColumn(name="idx")},
//		inverseJoinColumns={@JoinColumn(name="FRIEND_ID")})
//	private Set<People> friends = new HashSet<People>();
//
//	@ManyToMany(mappedBy="friends")
//	private Set<People> friendsList = new HashSet<People>();

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="PEOPLE_FRIENDS",
		joinColumns={@JoinColumn(name="idx")},
		inverseJoinColumns={@JoinColumn(name="FRIEND_ID")})
	private Set<People> friends = new HashSet<People>();

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="PEOPLE_FRIENDS",
		joinColumns={@JoinColumn(name="FRIEND_ID")},
		inverseJoinColumns={@JoinColumn(name="idx")})
	private Set<People> friendsList = new HashSet<People>();

	
	

	public Set<People> getFriends() {
		return friends;
	}

	public void setFriends(Set<People> friends) {
		this.friends = friends;
	}

	public Set<People> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(Set<People> friendsList) {
		this.friendsList = friendsList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public boolean isHasDied() {
		return hasDied;
	}

	public void setHasDied(boolean hasDied) {
		this.hasDied = hasDied;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public Set<TagElement> getTags() {
		return tags;
	}

	public void setTags(Set<TagElement> tags) {
		this.tags = tags;
	}
	
	public Set<Food> getFavouriteFood() {
		return favouriteFood;
	}

	public void setFavouriteFood(Set<Food> favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	@Override
	public String toString() {
		return "PersonPOJO [index=" + index + ", has_died=" + hasDied 
				+ ", age=" + age + ", eyeColor=" + eyeColor + ", name=" + name
				//+ ", tags=" + tags.toString() + ", food=" + favouriteFood.toString()
				+ ", gender=" + gender + ", company_id=" + companyId + "]";
	}
	
	
	
}
