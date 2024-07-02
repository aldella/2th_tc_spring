package com.kh.spring.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.spring.test.model.vo.Menu;

@Controller
public class TestController {

	@GetMapping("ajax2")
	public String ajax2() {
		return "test/test";
	}
	
	@ResponseBody
	@GetMapping(value="ajax2.do", produces="application/json; charset=UTF-8")
	public String selectMenu(int menuNumber) {
		Menu menu = new Menu(1, "순두부",  9500, "순두부");
		JSONObject jObj = new JSONObject();
		jObj.put("menuNumber", menu.getMenuNumber());
		jObj.put("menuName", menu.getMenuName());
		jObj.put("price", menu.getPrice());
		jObj.put("material", menu.getMaterial());
		
		return jObj.toJSONString();
	}
	
	@ResponseBody
	@GetMapping(value="ajax3.do", produces="application/json; charset=UTF-8")
	public Menu ajax3Method(int menuNumber) {
		Menu menu = new Menu(menuNumber, "순두부찌개", 9500, "순두부");
		return menu;
	}
	
	@ResponseBody
	@GetMapping(value="ajax4.do", produces="application/json; charset=UTF-8")
	public String findAll() {
		List<Menu> menus = new ArrayList();
		menus.add(new Menu(1, "하나", 1111, "일"));
		menus.add(new Menu(2, "둘", 2222, "이"));
		menus.add(new Menu(3, "셋", 3333, "삼"));
		
		return new Gson().toJson(menus);
	}
}
