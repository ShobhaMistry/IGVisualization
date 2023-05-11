package com.argusoft.who.igvisualization.entity;

import java.util.List;

public class PlanDefinition {
    private String resourceType;

    private String id;

    private List<Action> action;

    public PlanDefinition() {
    }

    public PlanDefinition(String id, String resourceType, List<Action> action) {
        this.id = id;
        this.resourceType = resourceType;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }

    // @Override
    // public String toString() {
    // return "PlanDefinition [id=" + id + ", resourceType=" + resourceType + ",
    // actions="
    // + "]";
    // }

}
