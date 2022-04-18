package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
	
	@Query("select r from Result r Where r.result_id =:i")
	public List<Result> getResultBySid(@Param("i") int Id);

}
