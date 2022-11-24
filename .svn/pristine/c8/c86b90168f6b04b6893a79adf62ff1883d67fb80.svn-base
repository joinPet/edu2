package egovframework.com.cmm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JtFileDetail {

    private long fileSeq;

    private long fileDetailNo;
    private String fileName;
    private String fileOriginalName;
    private String fileExtension;
    private long fileSize;
    private String filePath;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registDate;

    public long getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(long fileSeq) {
        this.fileSeq = fileSeq;
    }

    public long getFileDetailNo() {
        return fileDetailNo;
    }

    public void setFileDetailNo(long fileDetailNo) {
        this.fileDetailNo = fileDetailNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileOriginalName() {
        return fileOriginalName;
    }

    public void setFileOriginalName(String fileOriginalName) {
        this.fileOriginalName = fileOriginalName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(LocalDateTime registDate) {
        this.registDate = registDate;
    }

    @Override
    public String toString() {
        return "JtFileDetail{" +
                "fileSeq=" + fileSeq +
                ", fileDetailNo=" + fileDetailNo +
                ", fileName='" + fileName + '\'' +
                ", fileOriginalName='" + fileOriginalName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                ", registDate=" + registDate +
                '}';
    }
}
