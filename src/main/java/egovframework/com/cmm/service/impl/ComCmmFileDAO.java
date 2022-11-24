package egovframework.com.cmm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.model.JtFile;
import egovframework.com.cmm.model.JtFileDetail;

@Repository("ComCmmFileDAO")
public class ComCmmFileDAO extends EgovComAbstractDAO {

	//파일 상세 정보 조회
	public List<JtFileDetail> getFileDetailList(long fileSeq){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("fileSeq", fileSeq);
		return selectList("ComCmmFileDAO.getFileDetailList", paramMap);
	}

	//파일 상세 정보 조회 단건
	public JtFileDetail getFileDetailInfo(long fileSeq, long fileDetailNo){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("fileSeq", fileSeq);
		paramMap.put("fileDetailNo", fileDetailNo);
		return selectOne("ComCmmFileDAO.getFileDetailInfo", paramMap);
	}

	//파일 정보 등록
	int setFileInsert(JtFile jtFile){
		return insert("ComCmmFileDAO.setFileInsert", jtFile);
	}

	//게시글 파일 상세 정보 등록
	int setFileDetailInsert(JtFileDetail jtFileDetail){
		return insert("ComCmmFileDAO.setFileDetailInsert", jtFileDetail);
	}

	//게시글 파일 상세 정보 등록
	int setFileDetail(long fileSeq, long fileDetailNo){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("fileSeq", fileSeq);
		paramMap.put("fileDetailNo", fileDetailNo);
		return delete("ComCmmFileDAO.setFileDetail", paramMap);
	}

}
