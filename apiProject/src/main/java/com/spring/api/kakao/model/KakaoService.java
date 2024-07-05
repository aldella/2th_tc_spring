package com.spring.api.kakao.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class KakaoService {

	public String getToken(String code) throws IOException, ParseException {
		// TODO Auto-generated method stub
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(tokenUrl);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("POST");
		urlConnection.setDoOutput(true);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
		
		StringBuilder sb = new StringBuilder();
		sb.append("client_id=7c415afe1c27d9e3c6d607c7ab634426");
		sb.append("&grant_type=authorization_code");
		sb.append("&redirect_uri=http://localhost/api/oauth");
		sb.append("&code=");
		sb.append(code);
		
		bw.write(sb.toString());
		bw.flush();
		System.out.println(urlConnection.getResponseCode());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String line = "";
		String responseData = "";
		while((line=br.readLine()) != null) {
			responseData+= line;
			
		}
		System.out.println(responseData);
		
		JSONParser parser= new JSONParser();
		JSONObject element = (JSONObject)parser.parse(responseData);
		
		String accessToken = element.get("access_token").toString();
		br.close();
		bw.close();
		return accessToken;
	}

	public void logout(String accessToken) throws IOException {
		// TODO Auto-generated method stub
		String logoutUrl = "https://kapi.kakao.com/v1/user/logout";
		URL url = new URL(logoutUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer "+accessToken);
		////////////////////여기까지만해도 로그아웃은 되는데 그냥 어느 계정이 로그아웃됐는지 보고싶으니 출력해보기/////////////////////////
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String responseData="";
		String line="";
		while((line=br.readLine())!=null) {
			responseData += line;
		}
		System.out.println(responseData);
	}

	public SocialMember getUserInfo(String accessToken) throws IOException, ParseException {
		// 요청 보내기
		String userInfoUrl="https://kapi.kakao.com/v2/user/me";
		URL url = new URL(userInfoUrl);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer "+accessToken);
		
		// 응답 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String responseData = br.readLine();
		System.out.println(responseData);
		
		//문서에 따르면, 받은 응답 데이터는 GSON이므로, JSON Object형으로 변환해줘야함.
		JSONObject responseObj = (JSONObject)new JSONParser().parse(responseData); //responseData를 JSON형으로 변환한 responseObj
		JSONObject propObj = (JSONObject)responseObj.get("properties"); //responseObj 중 "properties"속성의 객체를 뽑아내서 다시 propObj로 집어넣음
		
		//소셜 로그인으로 만드는 회원 정보를 담을 클래스를 하나 만들고, JSON으로 받아온 정보들을 클래스에 넣어준다
		SocialMember sm = new SocialMember();
		sm.setId(responseObj.get("id").toString());
		sm.setNickName(propObj.get("nickname").toString());
		sm.setThumbnailImg(propObj.get("thumbnail_image").toString());
		System.out.println(sm);
		return sm;
		
		/*
		 * result obj = mapper.selectById(sm);
		 * if(obj !=  null) {
		 * 	return obj;
		 * } else {
		 * 	mapper.save(obj);
		 * }
		 * 
		 */
	}
	
}
