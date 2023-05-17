package com.argusoft.who.igvisualization.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ActivityDefinitionService {

    public final static ObjectMapper mapper = new ObjectMapper();

    public JsonNode getActivityDefinition() throws IOException {
        JsonNode activityDefinition = mapper.readTree(new File("src/main/resources/static/activityDefinition.json"));

        return activityDefinition;
    }

    public JsonNode getQuestionnaire() throws IOException {
        JsonNode activityDefinition = mapper.readTree(new File("src/main/resources/static/activityDefinition.json"));

        int index = 0;
        for (JsonNode a : activityDefinition.get("extension")) {
            index++;
            JsonNode valueCanonical = a.get("valueCanonical");
            if (valueCanonical == null) {
                continue;
            }
        }

        return activityDefinition.get("extension").get(--index);

    }
}
