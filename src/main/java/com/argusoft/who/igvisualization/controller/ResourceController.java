package com.argusoft.who.igvisualization.controller;

import java.util.List;

import com.argusoft.who.igvisualization.dto.ResourceDto;
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
    ResourceService resourceService;

    @GetMapping("/allResources")
    public List<String> getAllResources(){
        return resourceService.getAllResources();
    }

    @GetMapping("/allResourceCount")
    public List<ResourceDto> getAllResourceCount(){ return resourceService.getCountForResources();}

    @GetMapping("/getResource/{selectedResource}")
    public List<JsonNode> getResource(@PathVariable String selectedResource){
        return resourceService.getResource(selectedResource);
    }

}
