package org.assignment;

import java.io.IOException;
import java.util.List;

import org.assignment.client.TestRestClientCompany;
import org.assignment.client.TestRestClientPeople;
import org.assignment.dao.CompanyDAO;
import org.assignment.entity.Company;
import org.assignment.entity.People;
import org.assignment.view.PeoplePOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ComponentScan("org.assignment")
public class StartApplication {  
	
	@Autowired
	public static CompanyDAO companyDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);

		// This call can me commented to avoid parsing and loading JSON to DB
		new StartApplication().convert();
		
    }
	
	/*
	 * Following method can be used to read JSON files and load it to database.
	 * 
	 */
	public void convert() {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			
			//Define Custom Type reference for List<Company> type
	    	TypeReference<List<Company>> mapType = new TypeReference<List<Company>>() {};
	    	List<Company> jsonToCompanyList = mapper.readValue(new ClassPathResource("companies.json").getFile(), mapType);
	    	System.out.println("\nConvert JSON to List of company objects :");
	    	
	    	//Load Company from JSON file
	    	jsonToCompanyList.forEach(TestRestClientCompany :: addCompany);
	    	
	    	//Define Custom Type reference for List<people> type
	    	TypeReference<List<PeoplePOJO>> peopleMapType = new TypeReference<List<PeoplePOJO>>() {};
	    	List<PeoplePOJO> jsonToPeopleList = mapper.readValue(new ClassPathResource("people.json").getFile(), peopleMapType);
	    	System.out.println("\nConvert JSON to List of People :");

	    	//Load people objects and other components like tags, food and friends from JSON file
	    	jsonToPeopleList.forEach(TestRestClientPeople :: addPeople);
	    	jsonToPeopleList.forEach(TestRestClientPeople :: updatePeopleContent);

	    	
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 