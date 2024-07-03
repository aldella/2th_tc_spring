package com.spring.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiJavaApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty");
		
		//이제 RequestParam들을 붙여볼건데, "필수인 항목" 과 "return type"만 붙여보겠슴
		
		sb.append("?serviceKey=VNxvez7sdEhCCBV7wpGfvbcX4SlPWIZr0xmmWIU9GEer8dQepNfjTWBXeQcg%2FJGAV%2B9Qe%2FyhzcNxkQH37%2F0uvQ%3D%3D");
		sb.append("&dataTerm=DAILY");
		sb.append("&returnType=json");
		sb.append("&stationName=");
		sb.append(URLEncoder.encode("종로구","UTF-8"));
		String url = sb.toString();
		System.out.println(sb);
		
		//JAVA 코드로 URL로 요청을 보낼 것!
		// HTTPURLConnection 객체를 활용해서 API서버로 요청
		// 1. java.net.URL로 객체 생성 -> url값을 생성인자로 전달해야함!
		URL requestUrl = new URL(url);
		// 2. 생성한 url 객체를 가지고 HttpURLConnection객체를 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		// 3. 만든 HttpURLConnection 객체로, 어떤 방식으로 Request를 보내줄 것인지 기술
		urlConnection.setRequestMethod("GET");
		// 4. API 서버와 스트림 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		// 5. BufferedReader의 한 줄 불러들이고 그 결과를 반환하는 readLine() 메소드로 출력
		//	  이 때, readLine을 두 번 사용하면 한 줄씩 건너뛰고 출력하게 되므로, 주의가 필요하다. readLine은 호출할 때마다 읽어들이기를 반복하기 때문이다.
		//	  위쪽에서 먼저 변수를 선언하고, 한 번만 readLine하고 결과를 비교하고 저장하고 출력하기까지 변수에 담아서 해야한다.
		String responseXml = "";
		String responseJson = "";
		while((responseXml = br.readLine()) != null) {
			System.out.println(responseXml);
			responseJson += responseXml;
		}
		
		
		
		JsonObject jsonObj = JsonParser.parseString(responseJson).getAsJsonObject();
		System.out.println(jsonObj);
		
		JsonObject responseObj = jsonObj.getAsJsonObject("response");
		System.out.println(responseObj);
		
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		System.out.println(bodyObj);
		
		JsonArray items = bodyObj.getAsJsonArray("items"); // items property => [] JsonArray
		System.out.println(items);
		
		List<AirVO> list = new ArrayList();
		
		for(int i=0; i<items.size(); i++) {
			JsonObject firstItem = items.get(i).getAsJsonObject();
			System.out.println(firstItem);
			
			AirVO air = new AirVO();
			air.setPm10Value(firstItem.get("pm10Value").getAsString());
			air.setDataTime(firstItem.get("dataTime").getAsString());
			air.setO3Value(firstItem.get("o3Value").getAsString());
			air.setKhaiValue(firstItem.get("khaiValue").getAsString());
			
			list.add(air);
		}
		for(AirVO air : list) {
			System.out.println(air);
		}
		br.close();
		urlConnection.disconnect();
		
	}
}
