package org.assignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assignment.entity.People;
import org.assignment.service.PeopleService;
import org.assignment.view.PeoplePOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("paranuara")
public class PeopleController {
	@Autowired
	private PeopleService peopleService;
	@GetMapping("people/{id}")
	public ResponseEntity<People> getPeopleById(@PathVariable("id") Integer id) {
		People people = peopleService.getPeopleById(id);
		return new ResponseEntity<People>(people, HttpStatus.OK);
	}
	@GetMapping("allPeople")
	public ResponseEntity<List<People>> getAllPeoples() {
		List<People> list = peopleService.getAllPeople();
		return new ResponseEntity<List<People>>(list, HttpStatus.OK);
	}
	@PostMapping("people")
	public ResponseEntity<Void> addPeople(@RequestBody PeoplePOJO objPeople, UriComponentsBuilder builder) {
        boolean flag = peopleService.addPeople(objPeople);
        if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/people/{id}").buildAndExpand(objPeople.getIndex()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PostMapping("friend")
	public ResponseEntity<Void> addFriends(@RequestBody PeoplePOJO objPeople, UriComponentsBuilder builder) {
        boolean flag = peopleService.addFriends(objPeople);
        if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/people/{id}").buildAndExpand(objPeople.getIndex()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("people")
	public ResponseEntity<People> updatePeople(@RequestBody People people) {
		peopleService.updatePeople(people);
		return new ResponseEntity<People>(people, HttpStatus.OK);
	}
	@DeleteMapping("people/{id}")
	public ResponseEntity<Void> deletePeople(@PathVariable("id") Integer id) {
		peopleService.deletePeople(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	/*
	 * Problem Statement 1 : 
	 * Given a company, the API needs to return all their employees. 
	 * Provide the appropriate solution if the company does not have any employees.
	 */
	@GetMapping("listOfEmployee/company/{name}")
	public ResponseEntity<Map<String, Object>> getAllEmployeeList(@PathVariable("name") String name) {
		List<String> peopleLst = peopleService.getAllEmployeeList(name);
		Map <String, Object> employeeResult = new HashMap<String, Object>();
		if(null != peopleLst && peopleLst.size() > 0) {
			employeeResult.put("Employees of " + name, peopleLst);
			return new ResponseEntity<Map<String, Object>>(employeeResult, HttpStatus.OK);
		} else {
			employeeResult.put("Message", "No Employees Associated with " + name);
			return new ResponseEntity<Map<String, Object>>(employeeResult, HttpStatus.OK);
		}
	}
	
	/*
	 * Problem Statement 2 :
	 * Given 2 people, provide their information (Name, Age, Address, phone) 
	 * and the list of their friends in common which have brown eyes and are still alive.
	 */

	@GetMapping("people/commonFriends/{id1}/{id2}")
	public ResponseEntity<Map<String, Object>> getCommonFriends(@PathVariable("id1") Integer id1,
			@PathVariable("id2") Integer id2) {
		String eyeColor = "brown";
		
		List<Object> peopleLst = peopleService.getCommonFriends(id1, id2, eyeColor);
		People peopleOne = peopleService.getPeopleById(id1);
		People peopleTwo = peopleService.getPeopleById(id2);
		
		Map <String, Object> peopleOneMap = new HashMap<String, Object>();
		peopleOneMap.put("Name", peopleOne.getName());
		peopleOneMap.put("Age", peopleOne.getAge());
		peopleOneMap.put("Address", peopleOne.getAddress());
		peopleOneMap.put("Phone", peopleOne.getPhone());
		
		Map <String, Object> peopleTwoMap = new HashMap<String, Object>();
		peopleTwoMap.put("Name", peopleTwo.getName());
		peopleTwoMap.put("Age", peopleTwo.getAge());
		peopleTwoMap.put("Address", peopleTwo.getAddress());
		peopleTwoMap.put("Phone", peopleTwo.getPhone());
		
		Map <String, Object> requestResult = new HashMap<String, Object>();
		requestResult.put("People One", peopleOneMap);
		requestResult.put("People Two", peopleTwoMap);
		requestResult.put("Common Friends", peopleLst);
		return new ResponseEntity<Map<String, Object>>(requestResult, HttpStatus.OK);
	}
	
	/*
	 * Problem Statement 3 :
	 * 
	 *  Given 1 people, provide a list of fruits and vegetables they like. 
	 *  This endpoint must respect this interface for the output: 
	 *  {"username": "Ahi", "age": "30", "fruits": ["banana", "apple"], "vegetables": ["beetroot", "lettuce"]}
	 */
	
	@GetMapping("people/food/{id}")
	public ResponseEntity<Map<String, Object>> getFavouriteFoodDetails(@PathVariable("id") Integer id) {
		
		People people = peopleService.getPeopleById(id);
		List <String> foodNameList = peopleService.getFavouriteFood(people);
		Map <String, Object> requestResult = new HashMap<String, Object>();
		
		requestResult.put("username", people.getName());
		requestResult.put("age", people.getAge());
		requestResult.put("fruits", peopleService.getFruits(foodNameList));
		requestResult.put("vegetables", peopleService.getVegetables(foodNameList));
		return new ResponseEntity<Map<String, Object>>(requestResult, HttpStatus.OK);
	}

}