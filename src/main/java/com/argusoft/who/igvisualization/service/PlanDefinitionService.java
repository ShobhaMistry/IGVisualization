package com.argusoft.who.igvisualization.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlanDefinitionService {

    public final static ObjectMapper mapper = new ObjectMapper();

    public JsonNode getPlanDefinition() throws IOException {
        JsonNode planDefinition = mapper.readTree(new File("src/main/resources/static/planDefinition.json"));

        return planDefinition;
    }

    public JsonNode getActions() throws IOException {
        JsonNode planDefinition = mapper.readTree(new File("src/main/resources/static/planDefinition.json"));

        for (JsonNode a : planDefinition.get("action")) {
            String id = a.get("id").asText();
            String url = a.get("definitionCanonical").asText();
            System.out.println("ID : " + id + " url : " + url);
        }

        return planDefinition.get("action");
    }

}
