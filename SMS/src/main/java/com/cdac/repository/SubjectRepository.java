package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
	
}
