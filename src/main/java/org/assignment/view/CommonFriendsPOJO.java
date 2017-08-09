package org.assignment.view;

import java.util.List;

public class CommonFriendsPOJO {
	private PeoplePOJO peopleOne;
	private PeoplePOJO peopleTwo;
	private List<String> commonFriends;
	
	public PeoplePOJO getPeopleOne() {
		return peopleOne;
	}
	public void setPeopleOne(PeoplePOJO peopleOne) {
		this.peopleOne = peopleOne;
	}
	public PeoplePOJO getPeopleTwo() {
		return peopleTwo;
	}
	public void setPeopleTwo(PeoplePOJO peopleTwo) {
		this.peopleTwo = peopleTwo;
	}
	public List<String> getCommonFriends() {
		return commonFriends;
	}
	public void setCommonFriends(List<String> commonFriends) {
		this.commonFriends = commonFriends;
	}

}
