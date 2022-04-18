package com.cdac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.entity.Result;
import com.cdac.entity.Student;
import com.cdac.service.ResultService;

@Controller
public class ResultController {
	
	@Autowired
	private ResultService service;
	
	@GetMapping("/admin/add_result")
	private String addResult(Model model) {
		//System.out.println("inside register student");
		model.addAttribute("result", new Result());
		return "result";
	}
	@PostMapping("/admin/add_result")
	public String saveResult(@ModelAttribute("result") Result results,Model model) {
		service.save(results);
		model.addAttribute("result", results);
		return "resultView";
	}
	
	@GetMapping("/admin/viewresult")
	public String viewResult(Model model) {
	    List<Result> listresult = service.listAll();
	    model.addAttribute("listresult", listresult);
	     
	    return "ViewResult";
	}
	
	@RequestMapping("/admin/result_edit/{student}")
	public ModelAndView showEditResultPage(@PathVariable(name = "student") int id) {
	    ModelAndView mav = new ModelAndView("ResultById");
	    List<Result> result = service.getResultById(id);
	    mav.addObject("result", result);
	     
	    return mav;
	}
	
	@RequestMapping("/student_result")
	public String studentResult(@ModelAttribute("student") Student student, Model model,
							HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		student = (Student) session.getAttribute("currentUser");
		model.addAttribute("student", student);
		return "student_result";
	}
	
//	@GetMapping("/result")
//	public String resultPage(Model model) {
//		model.addAttribute("result", new Result());
//		return"result";
//	}
//	@PostMapping("/result")
//	public String resultPageSubmit(Model model) {
//		model.addAttribute("result", new Result());
//		return"result";
//	}
//	@PostMapping("/resultView")
//	public String resultViewPage(@ModelAttribute Result results,BindingResult result,Model model) {
//		model.addAttribute("result", results);
//		return"resultView";
//	}
	
}
