package com.argusoft.who.igvisualization.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.demoController.FileController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlanDefinitionService {

    @Autowired
    public FileController fileController;

    public final static ObjectMapper mapper = new ObjectMapper();

    public JsonNode getPlanDefinition() throws IOException {
        int index = 0;

        JsonNode bundle = fileController.getBundle();
        System.out.println("In for loop");
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            index++;
            
            if (resourceType.equalsIgnoreCase("PlanDefinition")) {

                return bundle.get("entry").get(--index);

            }
        }

        return bundle.get("entry").get(0);

    }

    public JsonNode getActions() throws IOException {

        System.out.println(getPlanDefinition().get("resource").get("action"));
        return getPlanDefinition().get("resource").get("action");
    }

}
