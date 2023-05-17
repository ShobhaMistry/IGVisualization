package com.argusoft.who.igvisualization.demoController;

import java.io.IOException;

import org.hl7.fhir.r4.model.PlanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.who.igvisualization.service.ActivityDefinitionService;
import com.argusoft.who.igvisualization.service.PlanDefinitionService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    PlanDefinitionService PDS = new PlanDefinitionService();

    @Autowired
    ActivityDefinitionService ADS = new ActivityDefinitionService();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = InstantSerializer.class)
    PlanDefinition planDefinition = new PlanDefinition();

    @GetMapping("/demo")
    public String demo() {
        String text = "Hello world";
        return text;
    }

    @GetMapping("/pd")
    public JsonNode getPD() throws IOException {
        return PDS.getPlanDefinition();
    }

    @GetMapping("/pd/actions")
    public JsonNode getActions() throws IOException {
        return PDS.getActions();
    }

    @GetMapping("/ad")
    public JsonNode getActivityDefinition() throws IOException {
        return ADS.getActivityDefinition();
    }

    @GetMapping("/ad/questionnaire")
    public JsonNode getQuestionnaire() throws IOException {
        return ADS.getQuestionnaire();
    }
}
