package com.argusoft.who.igvisualization.service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    public FileController fileController;

    public List<String> getAllResources(){

        List<String> allResources = new ArrayList<>();
        JsonNode bundle = fileController.getBundle();

        for(JsonNode a : bundle.get("entry")){
            String resourceType = a.get("resource").get("resourceType").asText();
            if (allResources.contains(resourceType)){
                continue;
            }
            System.out.println(resourceType);
            allResources.add(resourceType);
        }
        System.out.println("\n\n ALL RESOURCES : " + allResources);
        return allResources;
    }

    public List<JsonNode> getResource(String selectedResourceType){

        List<JsonNode> resource = new ArrayList<>();

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();

            if (resourceType.equalsIgnoreCase(selectedResourceType)) {

                resource.add(a);

            }

        }
        return resource;
    }

}
