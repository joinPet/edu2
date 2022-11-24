package kr.co.jointree.edu2.site.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
@Validated
@Repository("SiteReservationDAO")
public class SiteReservationDAO extends EgovComAbstractDAO {
	//예약등록
		int resInsert(Map<String, Object> resInfo) {
			return insert("SiteReservationDAO.resInsert", resInfo);
		}
	//받은 요청리스트
		List<Map<String, Object>> resList(String user_id){
			return selectList("SiteReservationDAO.resList", user_id);
		}
	//보낸 요청리스트
		List<Map<String, Object>> sendList(String user_id){
			return selectList("SiteReservationDAO.sendList", user_id);
		}
}