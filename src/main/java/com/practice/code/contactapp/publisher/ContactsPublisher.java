package com.practice.code.contactapp.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.code.contactapp.model.Contacts;

@RestController
public class ContactsPublisher {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@PostMapping("/publishContacts")
	public ResponseEntity<String> publishContacts(@RequestBody Contacts contacts){
		try {
			jmsTemplate.convertAndSend("bridgingcode-queue", contacts);
			return new ResponseEntity<String>("sent", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/publishContactsList")
	public ResponseEntity<String> publishContactsList(@RequestBody List<Contacts> contactList){
		try {
			jmsTemplate.convertAndSend("bridgingcode-queue", contactList);
			return new ResponseEntity<String>("sent", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
