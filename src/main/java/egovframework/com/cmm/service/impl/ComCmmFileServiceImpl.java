package egovframework.com.cmm.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.model.JtFile;
import egovframework.com.cmm.model.JtFileDetail;
import egovframework.com.cmm.service.ComCmmFileService;
import egovframework.com.cmm.util.EgovStringUtil;
import egovframework.com.cmm.util.FileUtil;

@Service("ComCmmFileService")
public class ComCmmFileServiceImpl implements ComCmmFileService {

	public static Logger log = LoggerFactory.getLogger(ComCmmFileServiceImpl.class);

	@Resource(name = "ComCmmFileDAO")
    private ComCmmFileDAO comCmmFileDAO;

	
	/**
	 * 파일 목록 정보
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<JtFileDetail> getFileDetailList( long seq ) {

		List<JtFileDetail> selectData = comCmmFileDAO.getFileDetailList(seq);
		//결과 데이터를 담는다.

		return selectData;
	}
	
	/**
	 * 파일 정보
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public JtFileDetail getFileDetailInfo( long seq, long no ) {

		JtFileDetail selectData = comCmmFileDAO.getFileDetailInfo(seq, no);
		//결과 데이터를 담는다.

		return selectData;
	}
	
	/**
	 * 파일 다운로드
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public void getFileDownLoad(
			HttpServletResponse response, long seq, long no
	) throws IOException {

		JtFileDetail selectData = comCmmFileDAO.getFileDetailInfo(seq, no);
		//결과 데이터를 담는다.

		FileUtil.downloadFile(selectData.getFilePath(), selectData.getFileName(), selectData.getFileOriginalName(), response);
	}

	/**
	 * 파일 업로드
	 * @param
	 * @return fileSeq
	 */
	public long setFileUpload(String path, String newFileFirstName, List<MultipartFile> multipartFiles, long seq) throws IOException {

		long fileSeq = seq;
		List<JtFileDetail> fileDataList = FileUtil.uploadFile(path, newFileFirstName, multipartFiles);
		if(fileDataList.size() > 0) {
			JtFile jtFile = new JtFile();
			if(fileSeq == 0){
				jtFile.setRegistDate(LocalDateTime.now());
				jtFile.setUseYn("Y");

				comCmmFileDAO.setFileInsert(jtFile);
			}else{
				jtFile.setFileSeq(fileSeq);
			}

			for(JtFileDetail fileDataInfo : fileDataList){
				fileDataInfo.setFileSeq(jtFile.getFileSeq());

				comCmmFileDAO.setFileDetailInsert(fileDataInfo);
				//파일상세 정보를 저장 한다.
			}
			fileSeq = jtFile.getFileSeq();
		}

		return fileSeq;
	}

	/**
	 * 파일 업로드
	 * @param
	 * @return fileSeq
	 */
	public String setFileUploadName(String path, String newFileFirstName, List<MultipartFile> multipartFiles, String name) throws IOException {
		List<JtFileDetail> fileDataList = FileUtil.uploadFileName(path, newFileFirstName, multipartFiles);

		if(EgovStringUtil.isNullToString(name).equals("")){
			for (JtFileDetail  fileDataInfo : fileDataList) {
				name = fileDataInfo.getFileName();
				break;
			}
		}

		return name;
	}

	/**
	 * 파일 삭제
	 * @param
	 */
	public void setFileDelete(JtFileDetail jtFileDetail) throws IOException {
		JtFileDetail getFileDetail = comCmmFileDAO.getFileDetailInfo(jtFileDetail.getFileSeq(), jtFileDetail.getFileDetailNo());
		FileUtil.deleteFile(getFileDetail.getFilePath(), getFileDetail.getFileName());

		//파일 정보 삭제
		comCmmFileDAO.setFileDetail(jtFileDetail.getFileSeq(), jtFileDetail.getFileDetailNo());
		
	}

}
