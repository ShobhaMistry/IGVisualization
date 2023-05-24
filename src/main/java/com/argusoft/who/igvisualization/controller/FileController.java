package com.argusoft.who.igvisualization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.argusoft.who.igvisualization.helper.FileUploadHelper;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    JsonNode bundle;

    @PostMapping("/file-upload")
    public ResponseEntity<String> uploadFile(@RequestParam("bundle") MultipartFile multipartFile) {

        bundle = null;
    
        try {
            if (multipartFile.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain a file");
            }

            if (!multipartFile.getContentType().equals("application/json")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Json file is allowed");
            }
            System.out.println(multipartFile);
            bundle = fileUploadHelper.uploadFile(multipartFile);

            return ResponseEntity.ok("File Uploaded Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!! Please Try Again");
    }

    @GetMapping("/getBundle")
    public JsonNode getBundle(){
        return bundle;
    }

    public void setBundle(JsonNode bundle) {
        this.bundle = bundle;
    }

    
}
