package com.tony.relationships.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tony.relationships.models.License;
import com.tony.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository){
		this.licenseRepository = licenseRepository;
	}
	
	public void create(License license){licenseRepository.save(license);}
	public void update(License license){licenseRepository.save(license);}
	public void destroy(long id){licenseRepository.delete(id);}
		
	public ArrayList<License> all(){
		return (ArrayList<License>) licenseRepository.findAll();
	}
	
	public String genLicense(){ // I really tried
		ArrayList<License> licenses = this.all();
		String res = "";
		
		if(licenses.size() == 0 || licenses == null){
			res = "000001";
		}else{
			License lastLicense = licenses.get(licenses.size()-1);
			double num = Double.parseDouble(lastLicense.getNumber());
			num += .000001;
			res = Double.toString(num);
		}
		
		return res;
	}
	
	public License findByIndex(long id){
		return licenseRepository.findOne(id);
	}
}
