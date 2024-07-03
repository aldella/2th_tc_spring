package com.spring.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AirVO {
	private String pm10Value;
	private String stationName;
	private String dataTime;
	private String o3Value;
	private String khaiValue;
}
