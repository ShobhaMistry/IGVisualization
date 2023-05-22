package com.argusoft.who.igvisualization.controller;

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
import com.argusoft.who.igvisualization.service.StructureDefinitionService;
import com.argusoft.who.igvisualization.service.StructureMapService;
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

    @Autowired
    StructureMapService structureMapService;

    @Autowired
    StructureDefinitionService structureDefinitionService;

    @GetMapping("/planDefinition")
    public JsonNode getPD() throws IOException {
        return planDefinitionService.getPlanDefinition();
    }

    @GetMapping("/planDefinition/actions")
    public JsonNode getActionsURL() throws IOException {
        return planDefinitionService.getActions();
    }

    @GetMapping("/activityDefinition")
    public List<JsonNode> getAllActivityDefinition(){
        return activityDefinitionService.getAllActivityDefinition();
    }

    @GetMapping("/activityDefinition/{id}")
    public JsonNode getActivityDefinitionByID(@PathVariable String id){
        return activityDefinitionService.getActivityDefinitionById(id);
    }

    @GetMapping("/questionnaire/{id}")
    public JsonNode getQuestionnaireById(@PathVariable String id){  
        return questionnaireService.getQuestionnaireById(id);
    }

    @GetMapping("/structureMap/{id}")
    public JsonNode getStructureMapById(@PathVariable String id){
        return structureMapService.getStructureMapById(id);
    }

    @GetMapping("/targetFromStructureMap/{id}")
    public List<JsonNode> getTargetFromStructureMap(@PathVariable String id){
        return structureMapService.getTargetFromStructureMap(id);
    }

    @GetMapping("/structureDefinition")
    public List<JsonNode> getAllStructureDefinition(){
        return structureDefinitionService.getAllStructureDefinition();
    }

    @GetMapping("/structureDefinition/{id}")
    public JsonNode getStructureDefinitionById(@PathVariable String id){
        return structureDefinitionService.getStructureDefinitionById(id);
    }
}
