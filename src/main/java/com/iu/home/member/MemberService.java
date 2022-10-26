package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public int setMember(MemberVO memberVO) throws Exception {
		int result = memberMapper.setMember(memberVO);
		Member_RoleVO member_RoleVO = new Member_RoleVO();
		member_RoleVO.setId(memberVO.getId());
		member_RoleVO.setNum(3L);
		memberMapper.setRole(member_RoleVO);
		return result;
	}
	
	public MemberVO getLogin(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberMapper.getLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		return memberVO;
	}
	
	public int getIdCheck(MemberVO memberVO) throws Exception {
		int result=0;
		memberVO = memberMapper.getIdCheck(memberVO);
		if(memberVO != null) {
			result=1;
		}
		return result;
	}
}
