package com.wengs.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wengs.example.service.TestService;

@Controller
public class EchoBrokerController {
	@Autowired
	private TestService testService;


	@RequestMapping(value = "/broke")
	public @ResponseBody String broke(@RequestParam("msg") String msg) {
		getTestService().sendTradeNotifications(msg);
		return "OK";
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

}
