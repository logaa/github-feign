package com.logaa.example.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

	@GetMapping(value = "/all")
	List<User> getAll() {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setName("获取所有用户");
		users.add(user);
		return users;
	}

	@GetMapping(value = "/{name}")
	User getByName(@PathVariable String name) {
		User user = new User();
		user.setName("获取用户：" + name);
		return user;
	}

	@GetMapping(value = "/id")
	User getById(String id) {
		User user = new User();
		user.setName("获取用户：" + id);
		return user;
	}

	@PostMapping(value = "/add")
	void addUser(@RequestBody User user) {
	}
}
