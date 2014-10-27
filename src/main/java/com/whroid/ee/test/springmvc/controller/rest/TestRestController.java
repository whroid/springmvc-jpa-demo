package com.whroid.ee.test.springmvc.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whroid.ee.base.util.StringUtil;
import com.whroid.ee.test.springmvc.entity.User;
import com.whroid.ee.test.springmvc.entity.base.RequestEntity;
import com.whroid.ee.test.springmvc.entity.base.ResponseEntity;
import com.whroid.ee.test.springmvc.entity.base.ResponseFactory;
import com.whroid.ee.test.springmvc.service.UserService;

@Controller
@RequestMapping("/rest/test")
public class TestRestController {

	Logger logger = LoggerFactory.getLogger(TestRestController.class);
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String id) {
		User user = userService.getUser(id);
		logger.debug(user.toString());
		ResponseFactory<User> rf = new ResponseFactory<User>(new String());
		rf.setPayload(user);
		return rf.getResponse();
	}

	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public ResponseEntity<String> getTest() {
		ResponseFactory<String> rf = new ResponseFactory<String>(new String());
		rf.setPayload("hello world");
		return rf.getResponse();
	}

	/**
	 * 获取考勤密钥
	 * 
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody RequestEntity<User> request) {

		ResponseFactory<String> rf = new ResponseFactory<String>(
				request.getRequestId());

		try {
			User user = request.getPayload();
			if (user == null) {
				rf.setMissFieldError("user");
				return rf.getResponse();
			}

			if (StringUtil.isEmpty(user.getName())) {
				rf.setMissFieldError("name");
				return rf.getResponse();
			}
			User u = userService.save(user);
			rf.setPayload(u.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rf.getResponse();
	}

}
