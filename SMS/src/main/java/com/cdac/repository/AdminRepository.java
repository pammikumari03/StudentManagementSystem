package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Query("select i from Admin i where i.email=?1")
	public Admin findByEmail(@Param("email") String email);

}
