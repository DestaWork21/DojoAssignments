package com.tony.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License,Long>{
	ArrayList<License> findByPersonIdContaining(long id);
}
