package com.cdac.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.entity.Admin;
import com.cdac.repository.*;


@Controller
public class AppController {
	

	@Autowired
	private AdminRepository aRepository;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	

	@GetMapping("/register")
	private String showSignUp(Model model) {
		model.addAttribute("admin",new Admin());
		return "signup_form";
	}
	@PostMapping("/process_register")
	public String processRegistration(Admin admin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodeString = encoder.encode(admin.getPassword());
		admin.setPassword(encodeString);
		aRepository.save(admin);
		return "register_success";
	}
	@RequestMapping("/admin/home")
	public String viewDashboard(Model model, Principal principal) {
		String username=principal.getName();
		Admin admin=aRepository.findByEmail(username);
		//System.out.print("Admin"+admin);
		model.addAttribute("admin",admin);
		return "admin_portal";
		
	}
	@RequestMapping("/admin/profile")
	public String profile(Model model, Principal principal) {
		String username=principal.getName();
		Admin admin=aRepository.findByEmail(username);
		//System.out.print("Admin"+admin);
		model.addAttribute("admin",admin);
		
		return "adminProfile";
	}
	@GetMapping("/forgotPassword")
	public String forgotpassword(Model model) {
		return "forgotPassword";
	}
	
}
