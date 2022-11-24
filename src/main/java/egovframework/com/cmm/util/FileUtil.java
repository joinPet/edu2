package egovframework.com.cmm.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.model.JtFileDetail;

/**
 * Class Name : FileUtil
 * Description :
 * Modification Information
 * @
 * @ 수정일			수정자		수정내용
 * @ ---------   	---------   -------------------------------
 * @ 2020.01.16     jjeong 	최초 생성
 *
 * @author jjeong
 * @since 2020.01.16
 * @version 1.0
 * @see
 *
 *Copyright (C) by JOINTREE All right reserved.
 */
public class FileUtil {

	public static Logger log = LoggerFactory.getLogger(FileUtil.class);

	/**
	 *  파일 생성
	 * @param directory
	 * @param physicalName
	 * @param contents
	 * @param charterSet
	 * @throws Exception
	 */
	public static void createFile(
			String directory, String physicalName, String contents, String charterSet
	) {

		String fileSeparator = directory.substring(directory.length() - 1, directory.length());
		if (!fileSeparator.equals(File.separator)) {
			directory = directory + File.separator;
		}

		if (charterSet == null) charterSet = "UTF-8";

		try {
			String fullPathFile = directory + physicalName;
			File file = new File(fullPathFile);

			if (file.isFile()) {
				file.delete();
			}

			FileUtils.writeStringToFile(file, contents, charterSet);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 파일을 삭제한다.
	 */
	public static void deleteFile(
			String directory, String fileName
	) throws IllegalStateException  {

		String fileSeparator = directory.substring(directory.length() - 1);
		if (!fileSeparator.equals(File.separator)) {
			directory = directory + File.separator;
		}

		String fullPathFile = directory + fileName;
		File file = new File(fullPathFile);

		if (file.isFile()) {
			file.delete();
		}
	}

	//파일 업로드
	public static List<JtFileDetail> uploadFile(
			String path
			, String newFileFirstName
			, List<MultipartFile> multipartFiles
	) throws IllegalStateException, IOException {

		//List<Map<String, Object>> fileList = new ArrayList<>();
		List<JtFileDetail> fileList = new ArrayList<>();

		// 파일이 빈 것이 들어오면 빈 것을 반환
		if(multipartFiles == null){
			return fileList;
		}

		String newFileName = ""; // 업로드 되는 파일명

		//파일경로 폴더 없을시 폴더를 생성 한다.
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}

		int num = 1;
		for (MultipartFile _multipartFile : multipartFiles) {
			JtFileDetail jJtFileDetail = new JtFileDetail();
			String fileName = _multipartFile.getOriginalFilename(); // 원본 파일 명
			//String fileName = StringUtils.cleanPath(new String(_multipartFile.getOriginalFilename().getBytes("8859_1"), StandardCharsets.UTF_8));
			// 원본 파일 명

			if(fileName != null && !fileName.equals("")){
				newFileName = newFileFirstName + "_" + System.currentTimeMillis()+num + "." + fileName.substring(fileName.lastIndexOf(".")+1);

				jJtFileDetail.setFileName(newFileName);
				jJtFileDetail.setFileOriginalName(fileName);
				jJtFileDetail.setFileExtension(fileName.substring(fileName.lastIndexOf(".")+1));
				jJtFileDetail.setFileSize(_multipartFile.getSize());
				jJtFileDetail.setFilePath(path.replace("D:", ""));
				jJtFileDetail.setRegistDate(LocalDateTime.now());

				String safeFile = path + newFileName;
				_multipartFile.transferTo(new File(safeFile));
				fileList.add(jJtFileDetail);
			}
			num++;
		}
		//파일 업러드를 한다 END

		return fileList;
	}

	//파일 업로드
	public static List<JtFileDetail> uploadFileName(
			String path
			, String newFileFirstName
			, List<MultipartFile> multipartFiles
	) throws IllegalStateException, IOException {

		List<JtFileDetail> fileList = new ArrayList<>();

		// 파일이 빈 것이 들어오면 빈 것을 반환
		if(multipartFiles == null){
			return fileList;
		}

		String newFileName = ""; // 업로드 되는 파일명

		//파일경로 폴더 없을시 폴더를 생성 한다.
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}

		int num = 1;
		for (MultipartFile _multipartFile : multipartFiles) {
			JtFileDetail jJtFileDetail = new JtFileDetail();
			String fileName = _multipartFile.getOriginalFilename(); // 원본 파일 명
			// 원본 파일 명

			if(fileName != null && !fileName.equals("")){
				newFileName = ((!EgovStringUtil.isNullToString(newFileFirstName).equals("")) ? newFileFirstName + "." + fileName.substring(fileName.lastIndexOf(".")+1) : fileName);

				jJtFileDetail.setFileName(newFileName);
				jJtFileDetail.setFileOriginalName(fileName);
				jJtFileDetail.setFileExtension(fileName.substring(fileName.lastIndexOf(".")+1));
				jJtFileDetail.setFileSize(_multipartFile.getSize());
				jJtFileDetail.setFilePath(path.replace("D:", ""));
				jJtFileDetail.setRegistDate(LocalDateTime.now());

				String safeFile = path + newFileName;
				_multipartFile.transferTo(new File(safeFile));
				fileList.add(jJtFileDetail);
			}
			num++;
		}
		//파일 업러드를 한다 END

		return fileList;
	}

	/**
	 * 파일을 다운로드
	 */
	public static void downloadFile(
			String filePath
			, String fileName
			, String fileDownName
			, HttpServletResponse response
	) throws IllegalStateException, IOException {

		log.debug("filePathName : {}", filePath + fileName);

		// 경로와 파일명으로 파일 객체를 생성한다.
		File dFile  = new File(filePath, fileName);

		// 파일 길이를 가져온다.
		int fSize = (int) dFile.length();

		// 파일이 존재
		if (fSize > 0) {

			// 파일명을 URLEncoder 하여 attachment, Content-Disposition Header로 설정
			String encodedFilename = "attachment; filename*=" + "UTF-8" + "''" + URLEncoder.encode(fileDownName, "UTF-8");

			// ContentType 설정
			response.setContentType("application/octet-stream; charset=utf-8");

			// Header 설정
			response.setHeader("Content-Disposition", encodedFilename);

			// ContentLength 설정
			response.setContentLength(fSize);

			BufferedInputStream in = null;
			BufferedOutputStream out = null;

				/* BufferedInputStream
				 *
					java.io의 가장 기본 파일 입출력 클래스
					입력 스트림(통로)을 생성해줌
					사용법은 간단하지만, 버퍼를 사용하지 않기 때문에 느림
					속도 문제를 해결하기 위해 버퍼를 사용하는 다른 클래스와 같이 쓰는 경우가 많음
				*/
			in = new BufferedInputStream(new FileInputStream(dFile));

				/* BufferedOutputStream
				 *
					java.io의 가장 기본이 되는 파일 입출력 클래스
					출력 스트림(통로)을 생성해줌
					사용법은 간단하지만, 버퍼를 사용하지 않기 때문에 느림
					속도 문제를 해결하기 위해 버퍼를 사용하는 다른 클래스와 같이 쓰는 경우가 많음
				*/
			out = new BufferedOutputStream(response.getOutputStream());

			try {
				byte[] buffer = new byte[4096];
				int bytesRead=0;

				 	/*
						모두 현재 파일 포인터 위치를 기준으로 함 (파일 포인터 앞의 내용은 없는 것처럼 작동)
						int read() : 1byte씩 내용을 읽어 정수로 반환
						int read(byte[] b) : 파일 내용을 한번에 모두 읽어서 배열에 저장
						int read(byte[] b. int off, int len) : 'len'길이만큼만 읽어서 배열의 'off'번째 위치부터 저장
				 	*/
				while ((bytesRead = in.read(buffer))!=-1) {
					out.write(buffer, 0, bytesRead);
				}

				// 버퍼에 남은 내용이 있다면, 모두 파일에 출력
				out.flush();
			}
			finally {
				/*
					현재 열려 in,out 스트림을 닫음
					메모리 누수를 방지하고 다른 곳에서 리소스 사용이 가능하게 만듬
				*/
				in.close();
				out.close();
			}
		} else {
			throw new FileNotFoundException("파일이 없습니다.");
		}

	}
}

