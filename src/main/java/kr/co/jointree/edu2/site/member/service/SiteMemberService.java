package kr.co.jointree.edu2.site.member.service;

import java.util.Map;

import kr.co.jointree.edu2.site.member.model.MemberVO;

public interface SiteMemberService {
	// 회원가입
	public int memberInsert(Map<String, Object> member);
	
	// 아이디 중복체크
	public int memberCheck(String user_id);
	
	//로그인
	Map<String, Object> memberLogin(Map<String, Object> paramMap);
	
	//Pet 아이디에 따른 pet 정보 가져오기
	Map<String, Object> memberInfo(String user_id);
}