package com.cg.details.UserCrud;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {
	
	private User1 user1;
	
	public CustomUserDetail(User1 user1) {
		this.user1= user1;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set= new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.user1.getRoles()));
		return set;
	}

	@Override
	public String getPassword() {
		return this.user1.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user1.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
