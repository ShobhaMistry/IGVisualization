package com.argusoft.who.igvisualization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class CodeSystemService {
         
    @Autowired
    public FileController fileController;

    
    
    public JsonNode getAllCode() {
        JsonNode codeSystem = null;
        
        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
           

            if (resourceType.equalsIgnoreCase("CodeSystem")) {

                codeSystem = a;
                
            }
            
        }
        return codeSystem.get("resource").get("concept");
    }
    
    public JsonNode getCodeById(String ID) {
        JsonNode codes = null;
        
        codes = getAllCode();
        for(JsonNode a : codes){
            
            String id = a.get("code").asText();

            if(id.equalsIgnoreCase(ID)){
                return a;
            }
        }
        return null;
    }
  
}
