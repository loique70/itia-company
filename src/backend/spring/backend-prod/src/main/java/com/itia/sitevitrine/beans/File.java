package com.itia.sitevitrine.beans;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class File {

    private String filename;
    private String fileSize;
    private String fileType;
    private byte[] file;

    public String getFilename() {
        return filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
