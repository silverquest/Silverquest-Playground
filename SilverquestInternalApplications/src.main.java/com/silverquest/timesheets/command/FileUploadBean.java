package com.silverquest.timesheets.command;

import org.gmr.web.multipart.GMultipartFile;

public class FileUploadBean {

    private GMultipartFile file;
    private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GMultipartFile getFile() {
		return file;
	}

	public void setFile(GMultipartFile file) {
		this.file = file;
	}


}