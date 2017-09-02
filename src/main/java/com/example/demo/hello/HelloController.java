package com.example.demo.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable String name) {
		return "Hello " + name;
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
		String name = person.getName();
		mess.setGreet("Hello " + name);
		return mess;
	}

}