package org.assignment.dao;

import java.util.List;
import org.assignment.entity.People;
import org.assignment.view.PeoplePOJO;

public interface PeopleDAO {
    List<People> getAllPeople();
    People getPeopleById(int peopleId);
    void addPeople(People people);
    void updatePeople(People people);
    void deletePeople(int peopleId);
    boolean peopleExists(String name, String email);
    void addFriends(PeoplePOJO objPeople);
    
    List<String> getAllEmployeeList(String name);
    List<Object> getCommonFriends(int idOne, int idTwo, String eyeColor);
    List<String> getFavouriteFood(People people);
} 