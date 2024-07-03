package com.spring.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/beach")
@RestController
@Slf4j
public class beachController {
	
	@GetMapping(produces="application/json; charset=UTF-8")
	public String airPollution(String stationName) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty");
		
		sb.append("?serviceKey=VNxvez7sdEhCCBV7wpGfvbcX4SlPWIZr0xmmWIU9GEer8dQepNfjTWBXeQcg%2FJGAV%2B9Qe%2FyhzcNxkQH37%2F0uvQ%3D%3D");
		sb.append("&dataTerm=DAILY");
		sb.append("&resultType=json");
		sb.append("&pageNo=1");
		String url = sb.toString();
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseData = br.readLine();
		
		br.close();
		urlConnection.disconnect();
		log.info("{}",responseData);
		return responseData;
	}
}
