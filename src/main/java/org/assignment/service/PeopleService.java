package org.assignment.service;

import java.util.List;

import org.assignment.entity.People;
import org.assignment.view.PeoplePOJO;

public interface PeopleService {
     List<People> getAllPeople();
     People getPeopleById(int peopleId);
     boolean addPeople(People people);
     boolean addPeople(PeoplePOJO objpeople);
     boolean addFriends(PeoplePOJO objpeople);
     void updatePeople(People people);
     void deletePeople(int peopleId);
     
     List<String> getAllEmployeeList(String name);
     List<Object> getCommonFriends(int idOne, int idTwo, String eyeColor);
     List<String> getFavouriteFood(People people);
     List<String> getFruits(List<String> foodList);
     List<String> getVegetables(List<String> foodList);
}