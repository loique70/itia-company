package com.itia.sitevitrine.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itia.sitevitrine.beans.File;
import com.itia.sitevitrine.models.UploadResponse;
import com.itia.sitevitrine.services.FileService;

@RestController
@CrossOrigin("*")
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<List<UploadResponse>> upload(@RequestParam("files") MultipartFile[] multiFiles)
            throws IOException {
        ArrayList<UploadResponse> list = new ArrayList<>();
        for (int i = 0; i < multiFiles.length; i++) {
            if (!(multiFiles[i].isEmpty())) {
                UploadResponse uploadResponse = fileService.addFile(multiFiles[i]);
                if (uploadResponse != null)
                    list.add(uploadResponse);
            }
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        File file = fileService.downloadFile(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(new ByteArrayResource(file.getFile()));
    }
}
