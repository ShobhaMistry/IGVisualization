package com.argusoft.who.igvisualization.service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.argusoft.who.igvisualization.dto.ResourceDto;
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
            allResources.add(resourceType);
        }
        return allResources;
    }

    public List<ResourceDto> getCountForResources(){

        List<String> resourceList = getAllResources();
        List<ResourceDto> allResourceCount = new ArrayList<>();
        JsonNode bundle = fileController.getBundle();

        for (String resource : resourceList){
            ResourceDto resourceDto = new ResourceDto();
            int count = 0;

            for(JsonNode a : bundle.get("entry")){
                resourceDto.setResourceName(resource);
                String resourceType = a.get("resource").get("resourceType").asText();
                if (resourceType.equalsIgnoreCase(resource)){
                    count += 1;
                }
                resourceDto.setResourceCount(count);
            }
            allResourceCount.add(resourceDto);
        }

        return allResourceCount;
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
