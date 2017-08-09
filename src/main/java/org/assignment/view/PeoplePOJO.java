package org.assignment.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeoplePOJO {
	
	@JsonProperty("_id")
	private String id;

	private int index;
	private String guid;
	private boolean has_died;
	private String balance;
	private String picture;
	private int age;
	private String eyeColor;
	private String name;
	private String gender;
	private int company_id;
	private String email;
	private String phone;
	private String address;
	private String about;
	private String registered;
	private List<String> tags;
	private List<FriendPOJO> friends;
	private String greeting;
	private List<String> favouriteFood;
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
	public boolean isHas_died() {
		return has_died;
	}
	public void setHas_died(boolean has_died) {
		this.has_died = has_died;
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
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
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
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<FriendPOJO> getFriends() {
		return friends;
	}
	public void setFriends(List<FriendPOJO> friends) {
		this.friends = friends;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public List<String> getFavouriteFood() {
		return favouriteFood;
	}
	public void setFavouriteFood(List<String> favouriteFood) {
		this.favouriteFood = favouriteFood;
	}
	@Override
	public String toString() {
		return "PersonPOJO [index=" + index + ", has_died=" + has_died 
				+ ", age=" + age + ", eyeColor=" + eyeColor + ", name=" + name
				+ ", gender=" + gender + ", \n\tcompany_id=" + company_id + ", tags=" + tags
				+ ", friends=" + friends.size() + ", favouriteFood=" + favouriteFood + "]";
	}
	
	
	
}
