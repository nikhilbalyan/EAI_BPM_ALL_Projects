package com.spring.client.home;

import org.springframework.web.client.RestTemplate;

public class ContractController {
	public static void main(String[] args) {

		String str = "http://localhost:8075/com-mayia/webapi/myresource/getIt";
		RestTemplate rst = new RestTemplate();
		String temp = rst.getForObject(str, String.class);
		System.out.println(temp);
	}
}
