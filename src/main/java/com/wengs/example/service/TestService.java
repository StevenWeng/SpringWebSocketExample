package com.wengs.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.wengs.example.Greeting;

@Service
public class TestService {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	public void sendTradeNotifications(String msg) {

		Map<String, Object> map = new HashMap<>();
		map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);

		this.messagingTemplate.convertAndSend("/topic/greetings", new Greeting(
				"Hello , "+msg+" !"));
		// this.messagingTemplate.convertAndSendToUser(result.user,
		// "/queue/position-updates", result.position, map);
	}
	
	@Scheduled(fixedDelay=1500)
	public void autoSend(){
		this.messagingTemplate.convertAndSend("/topic/greetings", new Greeting(
				"Hello Auto !"));
	}

	public SimpMessageSendingOperations getMessagingTemplate() {
		return messagingTemplate;
	}

	public void setMessagingTemplate(
			SimpMessageSendingOperations messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
}
