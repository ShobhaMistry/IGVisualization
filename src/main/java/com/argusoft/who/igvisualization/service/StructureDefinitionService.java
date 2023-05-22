package com.argusoft.who.igvisualization.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class StructureDefinitionService {
    
    @Autowired
    public FileController fileController;

    public List<JsonNode> structureDefinition = new ArrayList<JsonNode>();

    public List<JsonNode> getAllStructureDefinition(){
        int index = 0;

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            index++;

            if (resourceType.equalsIgnoreCase("StructureDefinition")) {

                System.out.println(a.get("resource").get("resourceType") + " " + a.get("resource").get("id"));
                structureDefinition.add(bundle.get("entry").get(--index));

            }

        }
        return structureDefinition;
    }

    public JsonNode getStructureDefinitionById(String ID){
        int index = 0;

        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();
            index++;
            
            if (resourceType.equalsIgnoreCase("StructureDefinition") && id.equalsIgnoreCase(ID)) {

                return bundle.get("entry").get(--index);

            }
            
        }
        return null;
    }
}
