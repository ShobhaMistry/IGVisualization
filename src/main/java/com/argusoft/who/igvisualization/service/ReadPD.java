package com.argusoft.who.igvisualization.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.json.ParseException;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

@Service
public class ReadPD {
    public final FhirContext fhirCtx = FhirContext.forR4();

    public final IParser parser = fhirCtx.newJsonParser().setPrettyPrint(true);

    public final ObjectMapper objectMapper = new ObjectMapper();
    

    public String path = "src/main/resources/static/pd1.json";

    public String getPlanDefinitionFromPD() throws StreamReadException, DatabindException, IOException, ParseException {

        org.hl7.fhir.r4.model.PlanDefinition PD = new org.hl7.fhir.r4.model.PlanDefinition();

        InputStream inputStream = new FileInputStream(new File(path));

        String x = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
       
        PD =  parser.parseResource(PlanDefinition.class,x);

        return parser.encodeResourceToString(PD);

    }

    public String getActions() throws StreamReadException, DatabindException, JSONException, IOException, ParseException{

        JSONObject jsonObject = new JSONObject(getPlanDefinitionFromPD());

        JSONArray actions = jsonObject.getJSONArray("action");

        System.out.println(actions);
        return actions.toString();
    }
  
}
