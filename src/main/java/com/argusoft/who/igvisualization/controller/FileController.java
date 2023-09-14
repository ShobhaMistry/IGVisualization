package com.argusoft.who.igvisualization.controller;

import com.argusoft.who.igvisualization.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.argusoft.who.igvisualization.helper.FileUploadHelper;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    JsonNode bundle;

    @PostMapping("/file-upload")
    public ResponseEntity<Response<String>> uploadFile(@RequestParam("bundle") MultipartFile multipartFile) {

        bundle = null;
    
        try {
            if (multipartFile.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Seerver Error",new String("File is Empty")));
            }

            if (!multipartFile.getContentType().equals("application/json")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Seerver Error",new String("Only Json file is allowed")));
            }
            bundle = fileUploadHelper.uploadFile(multipartFile);

            return ResponseEntity.ok(new Response<>(HttpStatus.OK,"File Uploaded Successfully",new String("File Uploaded Successfully")));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Seerver Error",new String("Something went wrong!!! Please Try Again")));
        }


    }

    @GetMapping("/getBundle")
    public JsonNode getBundle(){
        return bundle;
    }

    public void setBundle(JsonNode bundle) {
        this.bundle = bundle;
    }

    
}
