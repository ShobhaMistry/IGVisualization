package com.argusoft.who.igvisualization.entity;

import java.util.List;

public class Questionnaire {
    
    private String resourceType;

    private String id;

    private  List<Extension> extension;

    private String url;

    public Questionnaire() {
    }

    public Questionnaire(String resourceType, String id, List<Extension> extension, String url) {
        this.resourceType = resourceType;
        this.id = id;
        this.extension = extension;
        this.url = url;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Questionnaire [resourceType=" + resourceType + ", id=" + id + ", extension=" + extension + ", url="
                + url + "]";
    }

    
}
