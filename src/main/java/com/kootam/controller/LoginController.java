package com.kootam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kootam.entity.User;
import com.kootam.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String getAllUser(Model m) {
		List<User>user=userRepo.findAll();
		
		return "Login";
	}

	/*
	 * @PostMapping("/login") public String userLogin(@RequestParam String
	 * username,@RequestParam String password) {
	 * 
	 * 
	 * 
	 * User user = userRepo.getUserByUsernameAndPassword(username,password); //User
	 * user = null; if(user!=null) { System.out.println("user found");
	 * if(user.getUsertype().equals(User.USERTYPE_ADMIN)) {
	 * //model.addAttribute("AdminName", user.getUsername()); return "index"; } else
	 * if(user.getUsertype().equals(User.USERTYPE_BACKOFFICE)) { return
	 * "BackOfficeHome"; } }else { System.out.println("inside else"); return "/"; }
	 * return username;
	 * 
	 * }
	 * 
	 */

	//@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping("/login")
	public String login(@RequestParam(value="login-username") String username,
			@RequestParam(value="login-password") String password,Model m) {
		
		User user = userRepo.getUserByUsernameAndPassword(username,password);
		//User user = null;
				if(user!=null) {
					System.out.println("user found");
					if(user.getUsertype().equals(User.USERTYPE_ADMIN)) {
						m.addAttribute("AdminName", user.getUsername());
						return "/home";
					}
					else if(user.getUsertype().equals(User.USERTYPE_BACKOFFICE)) {
						return "redirect:/backoffice/";
					}
				}else {
					System.out.println("inside else");
					return "redirect:/loging";
				}
				return username;
				}
	}

