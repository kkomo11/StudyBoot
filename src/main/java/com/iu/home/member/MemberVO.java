package com.iu.home.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {

	@NotBlank(message="ID는 꼭 필요해!!!")
	private String id;
	@NotBlank
	@Size(max=10, min=4)
	private String pw;
	private String pw2;
	@NotBlank
	private String name;
	@Email
	private String email;
	private boolean enabled;
	private List<RoleVO> roleVOs;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// <? super T> : T타입이나 T의 부모타입
		// <? extends T> : T타입이나 T를 상속받는 타입
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pw;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		// 사용자 계정의 만료 여부
		// true : 만료 x
		// false : 만료 o
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		// 계정의 잠김 여부
		// true : 잠김 X
		// false : 잠김 O
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		// password 만료 여부
		// true : 만료 X
		// false : 만료 O
		return true;
	}
	
	public boolean isEnabled() {
		// isEnabled
		// 계정사용여부
		// true : 사용가능
		// false : 사용불가
		return true;
	}
}
