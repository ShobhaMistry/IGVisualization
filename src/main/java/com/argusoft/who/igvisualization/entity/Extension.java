package com.argusoft.who.igvisualization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Extension {
    
    private String url;

    @JsonIgnore
    private String valueCode;

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String valueCanonical;

    public Extension() {
    }

    public Extension(String url, String valueCanonical) {
        this.url = url;
        this.valueCanonical = valueCanonical;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValueCanonical() {
        return valueCanonical;
    }

    public void setValueCanonical(String valueCanonical) {
        this.valueCanonical = valueCanonical;
    }

    @Override
    public String toString() {
        return "Extension [url=" + url + ", valueCanonical=" + valueCanonical + "]";
    }

    
}
