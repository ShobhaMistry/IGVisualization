package com.argusoft.who.igvisualization.resourceProvider;

import java.io.IOException;

import org.apache.tomcat.util.json.ParseException;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.argusoft.who.igvisualization.service.ReadPD;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.DataFormatException;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.server.IResourceProvider;

@Component
public class PlanDefinitionResourceProvider implements IResourceProvider {

    @Autowired
    ReadPD readPD = new ReadPD();
    private final FhirContext fhirCtx = FhirContext.forR4();
    private final IParser parser = fhirCtx.newJsonParser().setPrettyPrint(false);

    @Override
    public Class<PlanDefinition> getResourceType() {
        return PlanDefinition.class;
    }


    public PlanDefinition getPlanDefinitionFromPD() throws StreamReadException, DatabindException, DataFormatException, IOException, ParseException{
        System.out.println(readPD.getPlanDefinitionFromPD());
        PlanDefinition pd = parser.parseResource(PlanDefinition.class, readPD.getPlanDefinitionFromPD());
        return pd;
    }

}
