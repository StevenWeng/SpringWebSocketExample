package com.wengs.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "hello")
public class HelloController {

	@RequestMapping(value = "hi")
	public String hello(@RequestParam("user") String user, Model model) {
		String workDir = System.getProperty("catalina.home");
		model.addAttribute("workDir", workDir);
		model.addAttribute("user", user);
		return "hello";
	}

	@RequestMapping(value = "json", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	Map<String, String> helloJson() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		return map;
	}

}
