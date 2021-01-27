package com.practice.code.contactapp.consumer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.practice.code.contactapp.model.Contacts;

@Component
public class ContactsConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactsConsumer.class);
	
	@JmsListener(destination = "bridgingcode-queue")
	public void messageListner(Contacts contacts) {
		LOGGER.info("Message received. {}", contacts);
	}
	
	@JmsListener(destination = "bridgingcode-queue")
	public void messageListner(List<Contacts> contacList) {
		LOGGER.info("Message received. {}", contacList.toString());
	}
	
	
}
