package com.argusoft.who.igvisualization.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.demoController.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ActivityDefinitionService {

    @Autowired
    public FileController fileController;

    public List<JsonNode> activityDefinition = new ArrayList<JsonNode>();

    public List<JsonNode> getAllActivityDefinition() {
        int index = 0;

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            index++;

            if (resourceType.equalsIgnoreCase("ActivityDefinition")) {

                activityDefinition.add(bundle.get("entry").get(--index));

            }

        }
        return activityDefinition;
    }

    public JsonNode getActivityDefinitionById(String ID){
        int index = 0;

        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();
            index++;
            
            if (resourceType.equalsIgnoreCase("ActivityDefinition") && id.equalsIgnoreCase(ID)) {

                return bundle.get("entry").get(--index);

            }
            
        }
        return null;
    }

}
