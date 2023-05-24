package com.argusoft.who.igvisualization.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.who.igvisualization.controller.FileController;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class QuestionnaireService {

    @Autowired
    public FileController fileController;
    
    
    public List<JsonNode> getAllQuestionnaire() {
        List<JsonNode> questionnaire = new ArrayList<JsonNode>();
        
        JsonNode bundle = fileController.getBundle();
        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();

            if (resourceType.equalsIgnoreCase("Questionnaire")) {

                questionnaire.add(a);

            }

        }
        return questionnaire;
    }

    public JsonNode getQuestionnaireById(String ID){

        JsonNode bundle = fileController.getBundle();

        for (JsonNode a : bundle.get("entry")) {

            String resourceType = a.get("resource").get("resourceType").asText();
            String id = a.get("resource").get("id").asText();
            
            if (resourceType.equalsIgnoreCase("Questionnaire") && id.equalsIgnoreCase(ID)) {

                return a;

            }
            
        }
        return null;
    }
}
