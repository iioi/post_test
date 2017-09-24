package com.study.demo1;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;

public class Demo2 {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String jsonStr = "{'name':'wang','pass':'1234'}";
		String url = "http://localhost:8080/sendJsonWait";
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, jsonStr, String.class);
		String res = responseEntity.getBody();
		System.out.println(res);
		String res2 = post(url,jsonStr);
		System.out.println(res2);
	}
	
	public static String post(String url,String params) {
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        
        JSONObject jsonObj = JSONObject.fromObject(params);
        
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        String result = restTemplate.postForObject(url, formEntity, String.class);
        
        return result;
	}
}
