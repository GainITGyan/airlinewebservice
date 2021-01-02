package com.gainitgyan.airlinewebservice.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gainitgyan.airlinewebservice.dto.RoleDto;
import com.gainitgyan.airlinewebservice.dto.UserDto;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -5784874189731392570L;

	private UserDto userDto;

	public UserPrincipal(UserDto userDto) {
		super();
		this.userDto = userDto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<RoleDto> roles = this.userDto.getRoles();
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		for (RoleDto role : roles) {
			authorities.addAll(role.getAuthorities().stream().map(a -> new SimpleGrantedAuthority(a.getName()))
					.collect(Collectors.toList()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.userDto.getPassword();
	}

	@Override
	public String getUsername() {
		return this.userDto.getUserName();
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
		return this.userDto.isEnabled();
	}

}
