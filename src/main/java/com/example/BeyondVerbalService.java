package com.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class BeyondVerbalService {

	
	@RequestMapping("/getToken")
	public @ResponseBody String greet() {
		RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap();
        
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        String str = "grant_type=client_credentials&apikey=4505880f-503a-4f10-9e39-0d6880f1d936";
        String str = "grant_type=client_credentials&apikey=b603c6ba-8847-4b47-8c02-96ada5154fc5";
        HttpEntity<String> request = new HttpEntity<String>(str, headers);
        Object ob = restTemplate.postForObject("https://token.beyondverbal.com/token", request, Object.class);
        
        System.out.println("Received token: " + ob.toString());
        
        return ob.toString();
    }
	
	public @ResponseBody 
	
	
}
