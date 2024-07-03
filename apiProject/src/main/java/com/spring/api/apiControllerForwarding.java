package com.spring.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class apiControllerForwarding {
	
	@GetMapping("air-pollution")
	public String airpollutionForwarding() {
		return "air-pollution";
	}
	@GetMapping("busan/beach")
	public String beach() {
		return "busan/beach";
	}
	@GetMapping("busan")
	public String busan() {
		return "busan/busan";
	}
	@GetMapping("shop")
	public String shop() {
		return "naver/shopping";
	}
	@GetMapping("map")
	public String map() {
		return "kakao/map";
	}
}
