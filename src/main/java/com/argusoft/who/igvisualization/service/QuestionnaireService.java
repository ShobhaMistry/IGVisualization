package com.argusoft.who.igvisualization.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuestionnaireService {
    ObjectMapper mapper = new ObjectMapper();

    public JsonNode getQuestionnaire() throws IOException {
        JsonNode questionnaire = mapper.readTree(new File("src/main/resources/static/questionnaire.json"));

        return questionnaire;
    }
}
