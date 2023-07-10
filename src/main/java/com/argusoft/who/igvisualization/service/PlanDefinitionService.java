package com.argusoft.who.igvisualization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanDefinitionService {

    @Autowired
    public FileController fileController;

    public List<JsonNode> getPlanDefinition(){
        List<JsonNode> planDefiniton = new ArrayList<JsonNode>();

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            
            if (resourceType.equalsIgnoreCase("PlanDefinition")) {

                planDefiniton.add(a);

            }
        }

        return planDefiniton;

    }

    public JsonNode getPlanDefinitionById(String ID){
        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();

            if (resourceType.equalsIgnoreCase("PlanDefinition") && id.equalsIgnoreCase(ID)) {

                return a;

            }

        }
        return null;
    }

    public JsonNode getActions(String pdId){

        return getPlanDefinitionById(pdId).get("resource").get("action");

    }

    public JsonNode getActionById(String pdId, String ID){
        JsonNode actions = null;

        actions = getActions(pdId);
        for(JsonNode a : actions){

            String id = a.get("id").asText();

            if(id.equalsIgnoreCase(ID)){
                return a;
            }
        }
        return null;
    }

}
