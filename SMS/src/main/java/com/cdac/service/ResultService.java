package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.entity.Result;
import com.cdac.repository.ResultRepository;

@Service
@Transactional
public class ResultService {
	
	@Autowired
	private ResultRepository rRepository;
	
	public void save(Result result) {
		rRepository.save(result);
    }
	public List<Result> listAll() {
        return rRepository.findAll();
    }
	
	public List<Result> getResultById(int Id){
		return rRepository.getResultBySid(Id);
	}
	public void delete(int id) {
        rRepository.deleteById(id);
    }
	 public Result get(int id) {
	        return rRepository.findById(id).get();
	    }


}
