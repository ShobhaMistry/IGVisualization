package com.argusoft.who.igvisualization.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class StructureMapService {

    @Autowired
    public FileController fileController;


    
    public List<JsonNode> getAllStructureMap() {
        List<JsonNode> structureMap = new ArrayList<JsonNode>();
        // int index = 0;

        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            // index++;

            if (resourceType.equalsIgnoreCase("StructureMap")) {

                structureMap.add(a);

            }

        }
        return structureMap;
    }

    public JsonNode getStructureMapById(String ID) {

        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();

            if (resourceType.equalsIgnoreCase("StructureMap") && id.equalsIgnoreCase(ID)) {

                return a;
            }

        }
        return null;
    }

    public List<JsonNode> getTargetFromStructureMap(String ID) {
        List<JsonNode> target = new ArrayList<JsonNode>();
        JsonNode structureMap = getStructureMapById(ID);

        for (JsonNode a : structureMap.get("resource").get("structure")) {

            String mode = a.get("mode").asText();

            if (mode.equalsIgnoreCase("target")) {
                target.add(a);
            }
        }
        return target;
    }

}
