package com.argusoft.who.igvisualization.demoController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.who.igvisualization.service.ActivityDefinitionService;
import com.argusoft.who.igvisualization.service.PlanDefinitionService;
import com.argusoft.who.igvisualization.service.QuestionnaireService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    PlanDefinitionService planDefinitionService;

    @Autowired
    ActivityDefinitionService activityDefinitionService;

    @Autowired
    QuestionnaireService questionnaireService;

    @GetMapping("/pd")
    public JsonNode getPD() throws IOException {
        return planDefinitionService.getPlanDefinition();
    }

    @GetMapping("/pd/actions")
    public JsonNode getActionsURL() throws IOException {
        return planDefinitionService.getActions();
    }

    @GetMapping("/ad")
    public List<JsonNode> getActivityDefinition(){
        return activityDefinitionService.getActivityDefinition();
    }

    @GetMapping("/questionnaire/{id}")
    public JsonNode getQuestionnaire(@PathVariable String id){  
        return questionnaireService.getQuestionnaire(id);
    }
}
