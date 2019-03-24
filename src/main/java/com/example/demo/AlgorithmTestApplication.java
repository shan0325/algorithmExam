package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmTestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AlgorithmTestApplication.class, args);
		
		Map<String, List> map = new HashMap<String, List>();
		List str = map.get("a");
		System.out.println(str.get(0));
		
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		
		
		AlgorithmTestApplication algorithmTestApplication = new AlgorithmTestApplication();
		algorithmTestApplication.print(list);
	}
	
	public void print(List<? extends String> list) {
		
		list.forEach(System.out::println);
	}

}

