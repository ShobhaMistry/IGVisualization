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
        int index = 0;

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            index++;
            
            if (resourceType.equalsIgnoreCase("PlanDefinition")) {

                return bundle.get("entry").get(--index);

            }
        }

        return null;

    }

    public JsonNode getActions(){

        return getPlanDefinition().get("resource").get("action");
        
    }

}
