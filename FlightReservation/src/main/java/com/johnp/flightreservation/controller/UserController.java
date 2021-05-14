package com.johnp.flightreservation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnp.flightreservation.dao.UserRepository;
import com.johnp.flightreservation.entities.User;
import com.johnp.flightreservation.service.SecurityService;

@Controller
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	SecurityService securityService;

	@RequestMapping("/")
    public String index() {
		LOGGER.info("Inside index, Redirect to Index.html");
        return "index.html";
    }
	
	@RequestMapping("/showreg")
	public String showRegister() {
		LOGGER.info("Inside showreg, redirect to registerUser.jsp");
		return "registerUser";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String showLoginPage(@ModelAttribute User user) {
		LOGGER.info("Inside showLoginPage");
		user.setPassword(encoder.encode(user.getPassword()));
		LOGGER.info("EncodedPassword for user:"+user.getEmail()+" is"+user.getPassword());
		LOGGER.info("USer :"+user+"/nsave method called from userRepo");
		userRepo.save(user);
		LOGGER.info("Redirect to Login.jsp");
		return "login";
	}

	@RequestMapping(value = "/login")
	public String showLogin() {
		LOGGER.info("Redirect to Login.jsp");
		return "login";
	}

	@RequestMapping(value = "/validatelogin")
	public String ValidateUser(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("Inside ValidateUSer");
		boolean loginresponse = securityService.login(email, password);
		//List<User> user = userRepo.findByEmail(email);
		//LOGGER.info("The user fetched from userrepo is :"+user);
		if (loginresponse){ 					//user.get(0).getEmail().equals(email) && user.get(0).getPassword().equals(password)) 
			System.out.println("Valid Login");
			LOGGER.info("Valid Login for Email :"+email);
			LOGGER.info("User roles: "+userRepo.findByEmail(email).get(0).getRoles());
			LOGGER.info("Redirect to SearchFlights.jsp");
			return "searchFlights";
		}
		else {
			LOGGER.error("User not Found"+email+" "+password);
		}
		modelMap.addAttribute("msg", "Invalid Credentials try again");
		LOGGER.warn("Invalid Login");
		LOGGER.info("Redirect to Login.jsp");
		return "login";
	}

}
