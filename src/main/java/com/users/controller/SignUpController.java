package com.users.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.users.dataservice.UserService;
import com.users.model.Users;
import com.users.service.DataConnectionService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class SignUpController {
	
	private static Logger logger = Logger.getLogger(SignUpController.class);
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("msg", "Please fill details");
		logger.info("Please fill details");
		return "signup";
	}

	@RequestMapping(value="signupprocess", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("signUpBean") SignUpBean signUpBean) {
		if (signUpBean != null && signUpBean.getUserName() != null && signUpBean.getPassword() != null && signUpBean.getEmailID() !=null) {
			String userName= signUpBean.getUserName();
			String password = signUpBean.getPassword();
			String emailId = signUpBean.getEmailID();
			boolean status=userService.insertUser(userName, password, emailId);
			if (status) {
				model.addAttribute("msg", "Successfully inserted.");
				logger.info("success");
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "signup";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "signup";
		}
	}
	
}
