package com.argusoft.who.igvisualization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class PlanDefinitionService {

    @Autowired
    public FileController fileController;

    public JsonNode getPlanDefinition(){

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            
            if (resourceType.equalsIgnoreCase("PlanDefinition")) {

                return a;

            }
        }

        return null;

    }

    public JsonNode getActions(){

        return getPlanDefinition().get("resource").get("action");
        
    }

    public JsonNode getActionById(String ID){
        JsonNode actions = null;

        actions = getActions();
        for(JsonNode a : actions){
            
            String id = a.get("id").asText();

            if(id.equalsIgnoreCase(ID)){
                return a;
            }
        }
        return null;
    }

}
