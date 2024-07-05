package com.spring.api.busan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("foods")
public class busanController {
	@GetMapping(value="/{pageNo}", produces="application/json; charset=UTF-8")
	public String foods(@PathVariable int pageNo) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("http://apis.data.go.kr/6260000/FoodService/getFoodKr");
		
		sb.append("?serviceKey=VNxvez7sdEhCCBV7wpGfvbcX4SlPWIZr0xmmWIU9GEer8dQepNfjTWBXeQcg%2FJGAV%2B9Qe%2FyhzcNxkQH37%2F0uvQ%3D%3D");
		sb.append("&pageNo="+pageNo);
		sb.append("&numOfRows=10");
		sb.append("&resultType=json");
		String url = sb.toString();
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseData = br.readLine();
		
		br.close();
		urlConnection.disconnect();
		
		return responseData;
	}
	
}
