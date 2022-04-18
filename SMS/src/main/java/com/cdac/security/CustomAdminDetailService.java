package com.cdac.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cdac.entity.Admin;
import com.cdac.repository.AdminRepository;

import net.bytebuddy.implementation.bytecode.Throw;

public class CustomAdminDetailService implements UserDetailsService {
		
		@Autowired
		private AdminRepository adminRepository;
		
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			
			Admin admin =adminRepository.findByEmail(email);
			if(admin==null) {
				throw new UsernameNotFoundException("User email not found");
			}
			return new CustomAdminDetails(admin);
		}
	}

