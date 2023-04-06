package com.capstone.application.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.capstone.application.model.Allergy;
import com.capstone.application.service.AllergyService;

import lombok.extern.log4j.Log4j2;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
@Log4j2
public class AllergyController 
{	
	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(AllergyController.class);
	
    private AllergyService allergyService;
    
	
	public AllergyController(AllergyService allergyService) {
		super();
		this.allergyService = allergyService;
	}

	@GetMapping("/allergyList")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Allergy> allergy() 
	{
		try {
		List < Allergy > allergy = allergyService.findAll();
		return allergy;
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			throw new HttpClientErrorException(HttpStatusCode.valueOf(500));
		}
	}
	
	
	@GetMapping("/allergy/{allergyId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Optional<Allergy> allergyById(@PathVariable int allergyId) 
	{
		try {
        Optional < Allergy > optional = allergyService.findById(allergyId);
		return optional;
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			throw new HttpClientErrorException(HttpStatusCode.valueOf(500));
		}
		
	}
	
	
	
	
	
}
