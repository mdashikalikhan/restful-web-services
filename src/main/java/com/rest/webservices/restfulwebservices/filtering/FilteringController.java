package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("values1", "values2", "values3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean(){
		return Arrays.asList(new SomeBean("values1", "values2", "values3"),
				new SomeBean("values11", "values12", "values13"),
				new SomeBean("values21", "values22", "values23"));
	}
}
