package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cdac.entity.Student;
import com.cdac.repository.Student_detailsRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private Student_detailsRepository sRepository;
	
	public void save(Student student_details) {
		sRepository.save(student_details);
    }
	public List<Student> listAll(String name) {
		if(name != null) {
			return sRepository.findAll(name);
		}
        return sRepository.findAll();
    }
	public void delete(int id) {
        sRepository.deleteById(id);
    }
	 public Student get(int id) {
	        return sRepository.findById(id).get();
	}
	 
	 
	 public Student findByEmailAndPassword(String email, String password) {
			Student student = null;
			if (email != null && password != null) {
				student = sRepository.findByEmailAndPassword(email, password);
			}
			return student;
		}
	 
	 public Student logins(String email) {
			Student student=sRepository.findByEmails(email);
			return student;
	}
}
