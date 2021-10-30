package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.License;
import com.codingdojo.models.Person;
import com.codingdojo.repositories.LicenseRepository;
import com.codingdojo.repositories.PersonRepository;

@Service
public class PersonLicenseServer {

	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public PersonLicenseServer(PersonRepository personRepository, LicenseRepository licenseRepository) {
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	//Retrieve by Id
	public Person getPersonById( Long id ) {
		Optional<Person> optionalPerson = personRepository.findById( id );
		if( optionalPerson.isPresent() ) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
		
	//Retrieve by Id
	public Person getPerson( Long id ) {
		return personRepository.findById( id ).orElse( null );
	}
	
	public List<Person> getUnlicensedPeople() {
		return personRepository.findByLicenseIdIsNull();
	}
	
	
	public Person createPerson( Person person ) {
		return personRepository.save( person );
	}
	
	
	public License createLicense( License license ) {
		String convertnum = String.valueOf( this.generateLicenseNumber() );
		license.setNumber( convertnum );
		return licenseRepository.save( license );
	}
	
	
	public int generateLicenseNumber() {
		License license = licenseRepository.findTopByOrderByNumberDesc();
		if( license == null )
			return 1;
		String numb = license.getNumber();
		Integer num = Integer.valueOf(numb);
		int largestNumber = num;
		largestNumber++;
		return (largestNumber);
	}
	
	
}
