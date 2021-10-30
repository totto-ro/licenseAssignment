package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.License;


public interface LicenseRepository extends Repository<License, Long>{
	public List<License> findAll();
	public License findTopByOrderByNumberDesc();
	
	License save( License license );
}
