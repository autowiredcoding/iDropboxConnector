package com.idropbox.models;

import java.io.InputStream;

public class DropboxFileInfo {
	
	
	
	public DropboxFileInfo(String fileName,InputStream fileContentStream,long fileSize){
		this.fileName=fileName;
		this.fileContentStream=fileContentStream;
		this.fileSize = fileSize;
	}
	
	String fileName;
	InputStream fileContentStream;
	long fileSize;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getFileContentStream() {
		return fileContentStream;
	}
	public void setFileContentStream(InputStream fileContentStream) {
		this.fileContentStream = fileContentStream;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	

}
