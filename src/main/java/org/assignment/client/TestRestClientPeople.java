package org.assignment.client;

import java.net.URI;

import org.assignment.entity.People;
import org.assignment.view.PeoplePOJO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestRestClientPeople {
    public void getPeopleByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/people/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<People> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, People.class, 1);
        People people = responseEntity.getBody();
        System.out.println("Id:"+people.getIndex()+", Name:"+people.getName());      
    }
    public void getAllPeoplesDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/allPeople";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<People[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, People[].class);
        People[] peoples = responseEntity.getBody();
        for(People people : peoples) {
        	System.out.println("Id:"+people.getIndex()+", Name:"+people.getName());
        }
    }
    public void addPeopleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
     	RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/paranuara/people";
		People objPeople = null;
		objPeople.setName("HIVERY");
	    HttpEntity<People> requestEntity = new HttpEntity<People>(objPeople, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public static void addPeople(People objPeople) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/paranuara/people";
		HttpEntity<People> requestEntity = new HttpEntity<People>(objPeople, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
    
    public static void addPeople(PeoplePOJO objPeople) {
    	System.out.println("POJO ->" + objPeople);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/paranuara/people";
		HttpEntity<PeoplePOJO> requestEntity = new HttpEntity<PeoplePOJO>(objPeople, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
    
    public static void updatePeopleContent(PeoplePOJO objPeople) {
    	System.out.println("POJO ->" + objPeople);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/paranuara/friend";
		HttpEntity<PeoplePOJO> requestEntity = new HttpEntity<PeoplePOJO>(objPeople, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
    
    public void updatePeopleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/people";
		People objPeople = null;
		objPeople.setIndex(1);
		objPeople.setName("HIVERY");
		HttpEntity<People> requestEntity = new HttpEntity<People>(objPeople, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deletePeopleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/people/{id}";
        HttpEntity<People> requestEntity = new HttpEntity<People>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	TestRestClientPeople client = new TestRestClientPeople();
        //client.getPeopleByIdDemo();
    	client.getAllPeoplesDemo();
    	//client.addPeopleDemo();
    	//client.updatePeopleDemo();
    	//client.deletePeopleDemo();
    }    
} 
