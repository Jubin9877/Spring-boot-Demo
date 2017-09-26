package com.example.demo.hello;

import org.springframework.web.bind.annotation.RestController;

import java.awt.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {
	
	@Autowired
	private CarMapperTest carmappertest;

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@RequestMapping("/mapping")
	public void getmapping() {
		carmappertest.shouldMapCarToDTO();
	}
	
	

	@RequestMapping("/hello")
	public String request(@RequestParam(value = "name", required = true) String name) {
		return "Hello " + name;
	}

	@RequestMapping("/hello/json")
	public @ResponseBody Message message(@RequestParam(value = "name", required = true) String name) {
		Message mess = new Message();
		mess.setGreet("Hello" + " " + name);
		return mess;
	}

	@RequestMapping(value = "/hello/person", method = RequestMethod.POST)
	public @ResponseBody Message person(@RequestBody PersonDetail person) {
		Message mess = new Message();
		String name = PersonDetail.name;
		mess.setGreet("Hello " + name);
		return mess;
	}

	@RequestMapping("/abc/")
	public @ResponseBody Message mess1(@RequestParam(required = false) String x,
			@RequestParam(value = "y", required = false) String name) {
		Message mess = new Message();
		mess.setGreet("Hello " + name + x);
		return mess;
	}
	
	@RequestMapping("/api/host/booking-request")
	public void messaage(@RequestParam(required = false) Integer propertyId,
			@RequestParam(required = false) String sort) {
		Message mess = new Message();
		mess.setGreet("Hello " + propertyId + sort);
		//System.out.println(("Hello " + propertyId + sort));
		
		if(sort != null && sort != "") {
			System.out.println("sort : "+ sort);
		}else {
			System.out.println("sort not available ");
		}
		
		if(propertyId != null) {
			System.out.println("propertyId : "+ propertyId);
		}else {
			System.out.println("propertyId not available ");
		}
	}
	
//	@RequestMapping("/hello")
//	public String getallTopics(){
//		return "H";
//	}
}