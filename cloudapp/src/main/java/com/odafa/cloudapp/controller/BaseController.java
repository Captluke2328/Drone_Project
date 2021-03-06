package com.odafa.cloudapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.odafa.cloudapp.configuration.ConfigReader;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseController {
    
	private final ConfigReader configurations;

    @GetMapping("/")
    public String indexPage(Model model) {
		
		model.addAttribute("publicIp", getPublicIpAddress());
		model.addAttribute("defaultSpeed", configurations.getDefaultSpeed());
		model.addAttribute("defaultAltitude", configurations.getDefaultAltitude());
		model.addAttribute("videoEndpoint", configurations.getVideoWsEndpoint());
        
        return "index";
    }
    
    @GetMapping("/v/{droneId}")
	public String getVideoFeed(Model model, @PathVariable("droneId") String droneId) {
		
		model.addAttribute("publicIp", getPublicIpAddress());
		model.addAttribute("droneId", droneId);
		model.addAttribute("videoEndpoint", configurations.getVideoWsEndpoint());
        
        return "video";
    }
    
	private String getPublicIpAddress() {
		// String ip = "";
		// try {
		// 	final URL whatismyip = new URL("http://checkip.amazonaws.com");

		// 	try(final BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()))){
		// 		ip = in.readLine();
		// 	}

		// } catch (Exception e) {
		// 	log.error(e.getMessage());
		// }
        // log.debug(ip);
         String ip = "10.60.215.193";
        //String ip = "192.168.8.115";

		return ip;
	}
}
