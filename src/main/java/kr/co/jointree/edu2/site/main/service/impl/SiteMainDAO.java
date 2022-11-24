package kr.co.jointree.edu2.site.main.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Validated
@Repository("SiteMainDAO")
public class SiteMainDAO extends EgovComAbstractDAO {

	//테스트 목록 정보 갯수
	int getTestCount(Map<String, Object> paramMap){
		return selectCount("SiteMainDAO.getTestCount", paramMap);
	}
	
    //테스트 목록 정보 조회
    List<Map<String, Object>> getTestList(Map<String, Object> paramMap){
        return selectList("SiteMainDAO.getTestList", paramMap);
    }

    //테스트 단건 정보 조회
    Map<String, Object> getTestInfo(Map<String, Object> paramMap){
        return selectOne("SiteMainDAO.getTestInfo", paramMap);
    }
    
    //테스트 정보 등록
    int setTestInsert(Map<String, Object> paramMap) {
    	return insert("SiteMainDAO.setTestInsert", paramMap);
    }
    
    //테스트 정보 수정
    int setTestUpdate(Map<String, Object> paramMap) {
    	return update("SiteMainDAO.setTestUpdate", paramMap);
    }
    
    //테스트 정보 삭제
    int setTestDelete(Map<String, Object> paramMap) {
    	return update("SiteMainDAO.setTestDelete", paramMap);
    }
    
}
