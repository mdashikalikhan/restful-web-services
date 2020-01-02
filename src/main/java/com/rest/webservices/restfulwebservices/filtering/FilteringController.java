package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("values1", "values2", "values3");
	}

	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("values1", "values2", "values3"),
				new SomeBean("values11", "values12", "values13"), new SomeBean("values21", "values22", "values23"));
	}

	@GetMapping("/dfilter")
	public MappingJacksonValue retrieveDynamicBean() {
		DynamicBean dynamicBean = new DynamicBean("values1", "values2", "values3", "values4");

		MappingJacksonValue mapping = new MappingJacksonValue(dynamicBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field4");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/dfilter-list")
	public MappingJacksonValue retrieveListOfDynamicBean() {
		List<DynamicBean> dynamicBeanList = Arrays.asList(new DynamicBean("values1", "values2", "values3", "values4"),
				new DynamicBean("values5", "values6", "values7", "values8"),
				new DynamicBean("values9", "values10", "values11", "values12"),
				new DynamicBean("values13", "values14", "values15", "values16"),
				new DynamicBean("values1", "values2", "values3", "values4"));

		MappingJacksonValue mapping = new MappingJacksonValue(dynamicBeanList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}
}
