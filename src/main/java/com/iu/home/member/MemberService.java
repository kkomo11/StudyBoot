package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

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
	
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) {
		boolean check = false;
		check = bindingResult.hasErrors();
		//check=false : 검증 성공
		//check=true : 검증 실패
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check=true;
//			bindingResult.rejectValue("멤버변수명(path)", "properties의 key(code)");
			
		}
		
		return check;
	}
	
//	public MemberVO getLogin(MemberVO memberVO, HttpSession session) throws Exception {
//		memberVO = memberMapper.getLogin(memberVO);
//		if(memberVO != null) {
//			session.setAttribute("member", memberVO);
//		}
//		return memberVO;
//	}
	
	public long getIdCheck(MemberVO memberVO) throws Exception {
		return memberMapper.getIdCheck(memberVO);
	}
}
