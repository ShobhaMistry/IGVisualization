package com.argusoft.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.json.ParseException;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

@Service
public class ReadPD {
    // public final FhirContext fhirCtx = FhirContext.forR4();

    // public final IParser parser = fhirCtx.newJsonParser().setPrettyPrint(true);

    // public final ObjectMapper objectMapper = new ObjectMapper();

    // public String path = "src/main/resources/static/pd1.json";

    // public String getPlanDefinitionFromPD() throws StreamReadException, DatabindException, IOException, ParseException {

    //     org.hl7.fhir.r4.model.PlanDefinition PD = new org.hl7.fhir.r4.model.PlanDefinition();

    //     InputStream inputStream = new FileInputStream(new File(path));

    //     // JSONParser jsonParser = new JSONParser(inputStream);
    //     // inputStream.toString();
    //     // Object jsonObject = jsonParser.parse();
    //     String x = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
       

    //     PD =  parser.parseResource(PlanDefinition.class,x);

    //     // PD = objectMapper.readValue(inputStream, PlanDefinition.class);
    //     return parser.encodeResourceToString(PD);

    // }
    public final ObjectMapper objectMapper = new ObjectMapper();
    public String path = "src/main/resources/static/pd.json";

    public com.argusoft.who.igvisualization.entity.PlanDefinition getActivityDefinitionFromPD() throws StreamReadException, DatabindException, IOException {

        com.argusoft.who.igvisualization.entity.PlanDefinition PD = new com.argusoft.who.igvisualization.entity.PlanDefinition();

        InputStream inputStream = new FileInputStream(new File(path));

        PD = objectMapper.readValue(inputStream, com.argusoft.who.igvisualization.entity.PlanDefinition.class);

        return PD;

    }
}
