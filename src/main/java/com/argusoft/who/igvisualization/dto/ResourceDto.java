package com.argusoft.who.igvisualization.dto;

public class ResourceDto {

    private String resourceName;

    private Integer resourceCount;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(Integer resourceCount) {
        this.resourceCount = resourceCount;
    }

    @Override
    public String toString() {
        return "ResourceDto{" +
                "resourceName='" + resourceName + '\'' +
                ", resourceCount=" + resourceCount +
                '}';
    }
}
