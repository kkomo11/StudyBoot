package com.iu.home.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {

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
	private boolean enable;
	private List<RoleVO> roleVOs;
}
