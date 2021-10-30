package com.codingdojo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.codingdojo.models.Person;

public interface PersonRepository extends Repository<Person, Long>{
	List<Person> findAll();
	
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
	List<Person> findByNoLicense();
	
	List<Person> findByLicenseIdIsNull();
	
	Person save( Person person );
	
	Optional<Person> findById( Long id );

	
	
}
