package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.UserDAO;

@Controller
public class AuthenticationController {

	private UserDAO userDAO;

	@Autowired
	public AuthenticationController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

//	@RequestMapping(path = "/login", method = RequestMethod.GET)
//	public String displayLoginForm() {
//		return "login";
//	}
//
//	@RequestMapping(path = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam String userId, 
//			@RequestParam String password,
//			@RequestParam(required = false) 
//			String destination, HttpSession session) {
//		if (userDAO.searchForUserIdAndPassword(userId, password)) {
//			session.setAttribute("currentUser", userDAO.getUserByUserId(userId));
//
//			if (destination != null && !destination.isEmpty()) {
//				return "redirect:" + destination;
//			} else {
//				return "redirect:/users/" + userId;
//			}
//		} else {
//			return "redirect:/login";
//		}
//	}
//
//	@RequestMapping(path = "/logout", method = RequestMethod.POST)
//	public String logout(ModelMap model, HttpSession session) {
//		model.remove("currentUser");
//		session.invalidate();
//		return "redirect:/";
//	}
}
