package com.argusoft.who.igvisualization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.demoController.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class StructureMapService {

    @Autowired
    public FileController fileController;

    public JsonNode getStructureMapById(String ID){
        int index = 0;

        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();
            index++;
            
            if (resourceType.equalsIgnoreCase("StructureMap") && id.equalsIgnoreCase(ID)) {

                return bundle.get("entry").get(--index);

            }
            
        }
        return null;
    }
}
