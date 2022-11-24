package egovframework.com.cmm.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.model.JtFileDetail;

public interface ComCmmFileService {
	
	List<JtFileDetail> getFileDetailList(long seq);
	
	JtFileDetail getFileDetailInfo(long seq, long no);

    void getFileDownLoad(HttpServletResponse response, long seq, long no) throws IOException;

    long setFileUpload(String path, String newFileFirstName, List<MultipartFile> multipartFiles, long seq) throws IOException;

    String setFileUploadName(String path, String newFileFirstName, List<MultipartFile> multipartFiles, String name) throws IOException;

    void setFileDelete(JtFileDetail jtFileDetail) throws IOException;

}
