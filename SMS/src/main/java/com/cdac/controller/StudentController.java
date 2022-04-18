package com.cdac.controller;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.entity.Student;
import com.cdac.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
    private StudentService service;
	
	@GetMapping("/admin/register_S")
	private String showRegistrationForrm(Model model) {
		System.out.println("inside register student");
		model.addAttribute("details",new Student());
		return "register_student";
	}
	
	@PostMapping("/admin/register_student")
	public String processRegistration(@ModelAttribute("student") Student student) {
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//String encodeString = encoder.encode(student.getPassword());
		//student.setPassword(encodeString);
		service.save(student);
		
		return "admin_portal";
	}
	
	@GetMapping("/admin/viewstudent")
	public String viewHomePage(Model model, @Param("name") String name) {
	    List<Student> listStudent = service.listAll(name);
	    model.addAttribute("listStudent", listStudent);
	     
	    return "ViewStudent";
	}
	
	@RequestMapping("/admin/delete/{Id}")
	public String deleteProduct(@PathVariable(name = "Id") int id) {
	    service.delete(id);
	    return "admin_portal";       
	}
	
	@PostMapping("/admin/save")
	public String updateStudent(@ModelAttribute("student") Student student) {
	    service.save(student);
	    return "ViewStudent";
	}
	
	@RequestMapping("/admin/edit/{Id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "Id") int id) {
	    ModelAndView mav = new ModelAndView("EditStudent");
	    Student student = service.get(id);
	    mav.addObject("student", student);
	     
	    return mav;
	}
	
	@GetMapping("/studentlogin")
	public String slogin(Model model) {
	model.addAttribute("student", new Student());
	return "studentlogin";
	}
	
	@PostMapping("/studentlogin")
	public String loginUser(@RequestParam(value = "email") String email, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {
		//String page = null;
		HttpSession session = request.getSession();
		Student student = service.findByEmailAndPassword(email, password);
		model.addAttribute("student", student);
		if(Objects.nonNull(student))  {
			session.setAttribute("currentUser", student);
			//page = "redirect:/student_dashboard";
			return"redirect:/student_dashboard";
		} else {
			//model.addAttribute("loginError", true);
			//model.addAttribute("loginValue", email);
			//page = "studentlogin";
			return"redirect:/studentlogin";
		}
		//return page;
	}
	
	@GetMapping("/student_dashboard")
	public String getDashboard(@ModelAttribute("student")Student student, Model model, 
														HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		student = (Student) session.getAttribute("currentUser");
		model.addAttribute("student", student);
		if (student == null)
			return "redirect:/studentlogin";
		else {
			return "student_dashboard";
	    }
		
	}

	@RequestMapping("/student_profile")
	public String profile(@ModelAttribute("student") Student student, Model model,
							HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		student = (Student) session.getAttribute("currentUser");
		model.addAttribute("student", student);
		return "student_profile";
	}
}


