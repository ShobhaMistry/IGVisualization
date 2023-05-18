package com.argusoft.who.igvisualization.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.argusoft.who.igvisualization.helper.FileUploadHelper;

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/file-upload")
    public ResponseEntity<String> uploadFile(@RequestParam("bundle") MultipartFile multipartFile) {

        try {
            if (multipartFile.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain a file");
            }

            if (!multipartFile.getContentType().equals("application/json")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Json file is allowed");
            }
            
            boolean f = fileUploadHelper.uploadFile(multipartFile);

            if (f) {
                return ResponseEntity.ok("File Uploaded Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!! Please Try Again");
    }
}
