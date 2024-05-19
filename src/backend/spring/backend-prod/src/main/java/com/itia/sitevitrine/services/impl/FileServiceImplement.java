package com.itia.sitevitrine.services.impl;

import java.io.IOException;

import com.itia.sitevitrine.beans.File;
import com.itia.sitevitrine.models.UploadResponse;
import com.itia.sitevitrine.services.FileService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.apache.commons.io.IOUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class FileServiceImplement implements FileService {

    private GridFsTemplate template;

    private GridFsOperations operations;

    public UploadResponse addFile(MultipartFile upload) throws IOException {
        DBObject metadata = new BasicDBObject();
        Object fileID = template.store(upload.getInputStream(),
                upload.getOriginalFilename(), upload.getContentType(),
                metadata);
        String relativePath = "/file/download/" + fileID.toString();
        return new UploadResponse(fileID.toString(), relativePath);
    }

    public File downloadFile(String id) throws IOException {
        GridFSFile gridFSFile = template.findOne(new Query(Criteria.where("_id").is(id)));
        File file = new File();
        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            file.setFilename(gridFSFile.getFilename());
            file.setFileType(gridFSFile.getMetadata().get("_contentType").toString());
            file.setFile(IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()));
        }
        return file;
    }
}
