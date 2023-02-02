package com.kootam.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kootam.entity.User;
import com.kootam.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/home")
	public String home(Model m) {
		
		List<User> list =userRepo.findAll();
		m.addAttribute("all_users",list);
		
		return "index";
	}
	
	@GetMapping("/add_user")
	public String addUser() {
		
		return "addUser";
	}
	
	@GetMapping("/edit_user/{id}")
	public String editUser(@PathVariable(value="id")Long id,Model m) {
		
		Optional<User> users =userRepo.findById(id);
		User user=users.get();
		m.addAttribute("users",user);
		
		return "editUser";
	}
	
	@PostMapping("/save_users")
	public String save_users(@ModelAttribute User users,HttpSession session) {
		
		userRepo.save(users);
		session.setAttribute("msg", "User Added Successfully...");
		return "redirect:/add_user";
	}
	
	
	@PostMapping("/update_users")
	public String save(@ModelAttribute User users,HttpSession session) {
		
		userRepo.save(users);
		session.setAttribute("msg", "User Update Successfully...");
		return "redirect:/home";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable(value="id") Long id,HttpSession session) {
		
		userRepo.deleteById(id);
		session.setAttribute("msg", "User Delete Successfully...");
		
		return "redirect:/home";
		
	}

}

	


