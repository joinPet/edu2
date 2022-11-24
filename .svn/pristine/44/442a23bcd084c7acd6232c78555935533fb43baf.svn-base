package kr.co.jointree.edu2.site.sample1.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Validated
@Repository("SiteSample1DAO")
public class SiteSample1DAO extends EgovComAbstractDAO {

	//목록 정보 갯수
	int getSample1Count(Map<String, Object> paramMap){
		return selectCount("SiteSample1DAO.getSample1Count", paramMap);
	}
	
    //목록 정보 조회
    List<Map<String, Object>> getSample1List(Map<String, Object> paramMap){
        return selectList("SiteSample1DAO.getSample1List", paramMap);
    }

    //단건 정보 조회
    Map<String, Object> getSample1Info(Map<String, Object> paramMap){
        return selectOne("SiteSample1DAO.getSample1Info", paramMap);
    }
    
    //정보 등록
    int setSample1Insert(Map<String, Object> paramMap) {
    	return insert("SiteSample1DAO.setSample1Insert", paramMap);
    }
    
    //정보 수정
    int setSample1Update(Map<String, Object> paramMap) {
    	return update("SiteSample1DAO.setSample1Update", paramMap);
    }
    
    //정보 삭제
    int setSample1Delete(Map<String, Object> paramMap) {
    	return update("SiteSample1DAO.setSample1Delete", paramMap);
    }
    
}
