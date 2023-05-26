package com.argusoft.who.igvisualization.helper;

import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FileUploadHelper {

    public final ObjectMapper mapper = new ObjectMapper();

    
    public JsonNode uploadFile(MultipartFile multipartFile) {
       
        JsonNode bundle=null;
        InputStream inputStream = null;

        try {

            inputStream = multipartFile.getInputStream();

            bundle = mapper.readTree(inputStream);

            return bundle;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
