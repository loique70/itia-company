package com.itia.sitevitrine.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.itia.sitevitrine.beans.File;
import com.itia.sitevitrine.models.UploadResponse;

public interface FileService {
        public UploadResponse addFile(MultipartFile upload) throws IOException;

        public File downloadFile(String id) throws IOException;
}
