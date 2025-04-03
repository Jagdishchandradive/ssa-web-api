package com.micro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebController {
	private static final Logger logger = LoggerFactory.getLogger(SSAWebController.class);
	
	@GetMapping("/find/{ssn}")
	public ResponseEntity<String>getSsnByName(@PathVariable Integer ssn){
	
		 logger.info("Received request to fetch state for SSN: {}", ssn);
		if (String.valueOf(ssn).length()!=9)
		{ logger.warn("Invalid SSN received: {}", ssn);
			return new ResponseEntity<>("Invalid",HttpStatus.BAD_REQUEST);}
		//Changes from Jagdish side
		int stateCode=ssn%10;
		 String stateName = switch (stateCode) {
	        case 1 -> "WashingtonDC";
	        case 2 -> "Ohio";
	        case 3 -> "Texas";
	        case 4 -> "California";
	        case 5 -> "Florida";
	        default -> "Invalid SSN";
	    };
		
		 logger.info("Computed state: {} for SSN: {}", stateName, ssn);
		return new ResponseEntity<>(stateName,HttpStatus.OK);
	}

}
