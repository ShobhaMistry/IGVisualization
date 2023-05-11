package com.argusoft.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.argusoft.who.igvisualization.entity.ActivityDefinition;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadAD {
    public final ObjectMapper objectMapper = new ObjectMapper();
    public String path = "src/main/resources/static/ad.json";

    public ActivityDefinition getActivityDefinitionFromAD() throws StreamReadException, DatabindException, IOException {

        ActivityDefinition AD = new ActivityDefinition();

        InputStream inputStream = new FileInputStream(new File(path));

        AD = objectMapper.readValue(inputStream, ActivityDefinition.class);

        return AD;

    }
}
