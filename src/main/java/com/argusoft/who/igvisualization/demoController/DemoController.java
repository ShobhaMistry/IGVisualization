package com.argusoft.who.igvisualization.demoController;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argusoft.resourceProvider.PlanDefinitionResourceProvider;
import com.argusoft.service.ReadAD;
import com.argusoft.service.ReadPD;
import com.argusoft.who.igvisualization.entity.ActivityDefinition;
import com.argusoft.who.igvisualization.entity.Extension;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class DemoController {

    ReadPD readPD = new ReadPD();
    ReadAD readAD = new ReadAD();

    // @Autowired
    // PlanDefinitionResourceProvider  planDefinitionResourceProvider = new PlanDefinitionResourceProvider();
    PlanDefinition planDefinition = new PlanDefinition();
    
    @GetMapping("/demo")
    public String demo() {
        String text = "Hello world";
        return text;
    }

    @GetMapping("/planDefinition")
    public com.argusoft.who.igvisualization.entity.PlanDefinition getPlanDefinition() throws StreamReadException, DatabindException, IOException, ParseException {
        System.out.println("in getPlanDefinition");
        return readPD.getActivityDefinitionFromPD();
    }

    // @GetMapping("/planDefinition/actions")
    // public List<PlanDefinitionActionComponent> getActions() throws StreamReadException, DatabindException, IOException, ParseException {
    //     return readPD.getPlanDefinitionFromPD().getAction();
    // }

    @GetMapping("/activityDefinition")
    public ActivityDefinition getActivityDefinition() throws StreamReadException, DatabindException, IOException{
        return readAD.getActivityDefinitionFromAD();
    }

    @GetMapping("/activityDefinition/questionnaire")
    public List<Extension> getQuestionnaire() throws StreamReadException, DatabindException, IOException{
        return readAD.getActivityDefinitionFromAD().getExtension();
    }
}
