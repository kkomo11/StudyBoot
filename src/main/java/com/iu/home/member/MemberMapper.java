package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {

	public int setMember(MemberVO memberVO) throws Exception;
	
	public MemberVO getLogin(String username) throws UsernameNotFoundException;
	
	public int setRole(Member_RoleVO member_RoleVO) throws Exception;
	
	public Long getIdCheck(MemberVO memberVO) throws Exception;
}
