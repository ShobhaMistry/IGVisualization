package com.argusoft.who.igvisualization.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Action {
    private String id;

    @JsonIgnore()
    private String description;

    private String definitionCanonical;

    public Action() {
    }

    public Action(String id, String description, String definitionCanonical) {
        this.id = id;
        this.description = description;
        this.definitionCanonical = definitionCanonical;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDefinitionCanonical(String definitionCanonical) {
        this.definitionCanonical = definitionCanonical;
    }

    public String getDefinitionCanonical() {
        return definitionCanonical;
    }

    @Override
    public String toString() {
        return "Action [id=" + id + ", description=" + description + ", definitionCanonical=" + definitionCanonical
                + "]";
    }

}
