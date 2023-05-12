package com.argusoft.who.igvisualization.demoController;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.who.igvisualization.service.PlanDefinitionService;
import com.argusoft.who.igvisualization.service.ReadAD;
import com.argusoft.who.igvisualization.service.ReadPD;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    ReadPD readPD = new ReadPD();

    @Autowired
    ReadAD readAD = new ReadAD();

    @Autowired
    PlanDefinitionService PDS = new PlanDefinitionService();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = InstantSerializer.class)
    PlanDefinition planDefinition = new PlanDefinition();
    
    @GetMapping("/demo")
    public String demo() {
        String text = "Hello world";
        return text;
    }

    @GetMapping("/planDefinition")
    public String getPlanDefinition() throws StreamReadException, DatabindException, IOException, ParseException {
        return readPD.getPlanDefinitionFromPD();
    }

    @GetMapping("/planDefinition/action")
    public String getActions() throws StreamReadException, DatabindException, IOException, ParseException{
        return readPD.getActions();
    }

    @GetMapping("/activityDefinition")
    public String getActivityDefinition() throws StreamReadException, DatabindException, IOException, ParseException{
        return readAD.getActivityDefinitionFromAD();
    }

    @GetMapping("/activityDefinition/questionnaire")
    public String getQuestionnaire() throws StreamReadException, DatabindException, IOException, JSONException, ParseException{
        return readAD.getQuestionnaire();
    }

    @GetMapping("/pd")
    public JsonNode getPD() throws IOException{
        return PDS.getPlanDefinition();
    }
}
