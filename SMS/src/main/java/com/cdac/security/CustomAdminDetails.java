package com.cdac.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cdac.entity.Admin;

public class CustomAdminDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
		private Admin admin;
		
		public CustomAdminDetails(Admin admin) {
			super();
			this.admin = admin;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(admin.getRole());
			return java.util.List.of(simpleGrantedAuthority);
			//return null;

		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return admin.getPassword();
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return admin.getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
	}

