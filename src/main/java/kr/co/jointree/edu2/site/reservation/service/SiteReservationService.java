package kr.co.jointree.edu2.site.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


public interface SiteReservationService {
	// 예약 등록
		public int resInsert(Map<String, Object> resInfo);
	// 받은 요청리스트
		public List<Map<String, Object>> resList(String user_id);
	// 보낸 요청리스트
		public List<Map<String, Object>> sendList(String user_id);
}