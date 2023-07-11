package com.argusoft.who.igvisualization.controller;

import java.io.IOException;
import java.util.List;

import com.argusoft.who.igvisualization.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ResourceController {

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

    @Autowired
    LibraryService libraryService;

    @Autowired
    ValueSetService valuesetService;    

    @Autowired
    CodeSystemService codeSystemService;

    @Autowired
    ResourceService resourceService;

    @GetMapping("/allResources")
    public List<String> getAllResources(){
        return resourceService.getAllResources();
    }

    @GetMapping("/getResource/{selectedResource}")
    public List<JsonNode> getResource(@PathVariable String selectedResource){
        return resourceService.getResource(selectedResource);
    }

    @GetMapping("/planDefinition")
    public List<JsonNode> getPD() throws IOException {
        return planDefinitionService.getPlanDefinition();
    }

    @GetMapping("/planDefinition/{id}")
    public JsonNode getPlanDefinitonById(@PathVariable String id){
        return planDefinitionService.getPlanDefinitionById(id);
    }

    @GetMapping("/planDefinition/{pdId}/actions")
    public JsonNode getActionsURL(@PathVariable String pdId) throws IOException {
        return planDefinitionService.getActions(pdId);
    }

    @GetMapping("/planDefinition/{pdId}/actions/{id}")
    public JsonNode getActionById(@PathVariable String pdId,@PathVariable String id){
        return planDefinitionService.getActionById(pdId,id);
    }

    @GetMapping("/activityDefinition")
    public List<JsonNode> getAllActivityDefinition() {
        return activityDefinitionService.getAllActivityDefinition();
    }

    @GetMapping("/activityDefinition/{id}")
    public JsonNode getActivityDefinitionByID(@PathVariable String id) {
        return activityDefinitionService.getActivityDefinitionById(id);
    }

    @GetMapping("/questionnaire")
    public List<JsonNode> getAllQuestionnaire(){
        return questionnaireService.getAllQuestionnaire();
    }

    @GetMapping("/questionnaire/{id}")
    public JsonNode getQuestionnaireById(@PathVariable String id) {
        return questionnaireService.getQuestionnaireById(id);
    }

    @GetMapping("/structureMap")
    public List<JsonNode> getAllStructureMapBy() {
        return structureMapService.getAllStructureMap();
    }

    @GetMapping("/structureMap/{id}")
    public JsonNode getStructureMapById(@PathVariable String id) {
        return structureMapService.getStructureMapById(id);
    }

    @GetMapping("/targetFromStructureMap/{id}")
    public List<JsonNode> getTargetFromStructureMap(@PathVariable String id) {
        return structureMapService.getTargetFromStructureMap(id);
    }

    @GetMapping("/structureDefinition")
    public List<JsonNode> getAllStructureDefinition() {
        return structureDefinitionService.getAllStructureDefinition();
    }

    @GetMapping("/structureDefinition/{id}")
    public JsonNode getStructureDefinitionById(@PathVariable String id) {
        return structureDefinitionService.getStructureDefinitionById(id);
    }

    @GetMapping("/library")
    public List<JsonNode> getAllLibrary(){
        return libraryService.getAllLibrary();
    }

    @GetMapping("/library/{id}")
    public JsonNode getLibraryById(@PathVariable String id){
        return libraryService.getLibraryById(id);
    }

    @GetMapping("/valueSet")
    public List<JsonNode> getAllValueSet(){
        return valuesetService.getAllValueSet();
    }

    @GetMapping("/valueSet/{id}")
    public JsonNode getValueSetById(@PathVariable String id){
        return valuesetService.getValueSetById(id);
    }

    @GetMapping("/code")
    public JsonNode getAllCode(){
        return codeSystemService.getAllCode();
    }

    @GetMapping("/code/{id}")
    public JsonNode getCodeById(@PathVariable String id){
        return codeSystemService.getCodeById(id);
    }

}
