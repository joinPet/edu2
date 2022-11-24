package kr.co.jointree.edu2.site.sample2.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Validated
@Repository("SiteSample2DAO")
public class SiteSample2DAO extends EgovComAbstractDAO {

	//목록 정보 갯수
	int getSample2Count(Map<String, Object> paramMap){
		return selectCount("SiteSample2DAO.getSample2Count", paramMap);
	}
	
    //목록 정보 조회
    List<Map<String, Object>> getSample2List(Map<String, Object> paramMap){
        return selectList("SiteSample2DAO.getSample2List", paramMap);
    }

    //단건 정보 조회
    Map<String, Object> getSample2Info(Map<String, Object> paramMap){
        return selectOne("SiteSample2DAO.getSample2Info", paramMap);
    }
    
    //정보 등록
    int setSample2Insert(Map<String, Object> paramMap) {
    	return insert("SiteSample2DAO.setSample2Insert", paramMap);
    }
    
    //정보 수정
    int setSample2Update(Map<String, Object> paramMap) {
    	return update("SiteSample2DAO.setSample2Update", paramMap);
    }
    
    //정보 삭제
    int setSample2Delete(Map<String, Object> paramMap) {
    	return update("SiteSample2DAO.setSample2Delete", paramMap);
    }
    
}
