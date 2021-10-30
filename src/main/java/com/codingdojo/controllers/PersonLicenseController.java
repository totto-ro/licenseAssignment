package com.codingdojo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.License;
import com.codingdojo.models.Person;
import com.codingdojo.services.PersonLicenseServer;

@Controller
public class PersonLicenseController {
	
	private final PersonLicenseServer personLicenseServer;
	
	//Constructor
	public PersonLicenseController( PersonLicenseServer personLicenseServer ) {
		this.personLicenseServer = personLicenseServer;
		
	}
	
	//Retrieving all Info
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String AllInfo( @ModelAttribute( "person" ) Person person, Model model ) {
		List<Person> personList = personLicenseServer.getAllPersons();
		
		model.addAttribute( "personList", personList );
		return "allinfo.jsp";
	}
	
	//Render page to create person
	@RequestMapping( value="/persons/new", method=RequestMethod.GET )
	public String NewPerson( @ModelAttribute( "person" ) Person person ) {
		return "new.jsp";
	}
	
	//Save person 
	@RequestMapping( value="/persons/new", method=RequestMethod.POST )
	public String CreatePerson(@Valid @ModelAttribute( "person" ) Person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "new.jsp";
		}
		personLicenseServer.createPerson(person);
		return "redirect:/";
	}
	
	//Render page to create license
	@RequestMapping( value="/licenses/new", method=RequestMethod.GET )
	public String createLicense(@ModelAttribute( "license" ) License license, Model model ) {
		
		List<Person> unlicensed = personLicenseServer.getUnlicensedPeople();
		model.addAttribute( "person", unlicensed );
		return "newLicense.jsp";
	}
	
	@RequestMapping( value = "/licenses/new", method=RequestMethod.POST )
	public String CreateLicense(@Valid @ModelAttribute( "license" ) License license, BindingResult result) {
		
		if( result.hasErrors() )
			return "/licenses/new.jsp";
		personLicenseServer.createLicense( license );
		return "redirect:/";
	}
	
	@RequestMapping( value= "/{id}", method=RequestMethod.GET )
	public String ShowPerson(@PathVariable("id") Long id, Model model ) {
		
		
		model.addAttribute("person", personLicenseServer.getPersonById( id ) );
		return "show.jsp";
	}
	
		
	
	

}
