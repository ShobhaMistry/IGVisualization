package com.argusoft.who.igvisualization.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ActivityDefinitionService {

    @Autowired
    public FileController fileController;

    
    public List<JsonNode> getAllActivityDefinition() {
         List<JsonNode> activityDefinition = new ArrayList<JsonNode>();

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            
            if (resourceType.equalsIgnoreCase("ActivityDefinition")) {

                activityDefinition.add(a);

            }

        }
        return activityDefinition;
    }

    public JsonNode getActivityDefinitionById(String ID) {
     
        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();
          
            if (resourceType.equalsIgnoreCase("ActivityDefinition") && id.equalsIgnoreCase(ID)) {

                return a;

            }

        }
        return null;
    }

}
