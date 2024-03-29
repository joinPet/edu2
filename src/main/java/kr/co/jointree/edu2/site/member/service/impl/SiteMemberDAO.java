package kr.co.jointree.edu2.site.member.service.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Validated
@Repository("SiteMemberDAO")
public class SiteMemberDAO extends EgovComAbstractDAO {

	// 회원등록
	int memberInsert(Map<String, Object> member) {
		return insert("SiteMemberDAO.memberInsert", member);
	}

	// 로그인
	Map<String, Object> memberLogin(Map<String, Object> paramMap) {
		return selectOne("SiteMemberDAO.memberLogin", paramMap);
	}

	public int memberCheck(String user_id) {
		return getSqlSession().selectOne("SiteMemberDAO.memberCheck", user_id);
	}

	// 회원정보 가져오기
	Map<String, Object> memberInfo(String user_id) {
		return selectOne("SiteMemberDAO.memberInfo", user_id);
	}
	
	// 아이디 찾기
	public String memberFindID(String email) throws Exception{
		return selectOne("SiteMemberDAO.memberFindID", email);
	}
}