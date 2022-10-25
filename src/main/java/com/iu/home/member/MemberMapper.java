package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setMember(MemberVO memberVO) throws Exception;
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	public int setRole(Member_RoleVO member_RoleVO) throws Exception;
}
