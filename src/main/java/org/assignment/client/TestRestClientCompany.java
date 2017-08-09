package org.assignment.client;

import java.net.URI;

import org.assignment.entity.Company;
import org.assignment.view.CompanyPOJO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestRestClientCompany {
    public void getCompanyByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/company/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Company> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Company.class, 1);
        Company company = responseEntity.getBody();
        System.out.println("Id:"+company.getIndex()+", Name:"+company.getCompany());      
    }
    public void getAllCompanysDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/companys";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Company[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Company[].class);
        Company[] companys = responseEntity.getBody();
        for(Company company : companys) {
        	System.out.println("Id:"+company.getIndex()+", Name:"+company.getCompany());
        }
    }
    public void addCompanyDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
     	RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/paranuara/company";
		Company objCompany = new Company();
		objCompany.setCompany("HIVERY");
	    HttpEntity<Company> requestEntity = new HttpEntity<Company>(objCompany, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public static void addCompany(Company objCompany) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/paranuara/company";
		HttpEntity<Company> requestEntity = new HttpEntity<Company>(objCompany, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }
    public void updateCompanyDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/company";
		Company objCompany = new Company();
		objCompany.setIndex(1);
		objCompany.setCompany("HIVERY");
		HttpEntity<Company> requestEntity = new HttpEntity<Company>(objCompany, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteCompanyDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/paranuara/company/{id}";
        HttpEntity<Company> requestEntity = new HttpEntity<Company>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	TestRestClientCompany client = new TestRestClientCompany();
        //client.getCompanyByIdDemo();
    	client.getAllCompanysDemo();
    	//client.addCompanyDemo();
    	//client.updateCompanyDemo();
    	//client.deleteCompanyDemo();
    }    
} 
