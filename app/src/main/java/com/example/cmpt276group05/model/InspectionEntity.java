package com.example.cmpt276group05.model;

import java.util.Date;

public class InspectionEntity extends BaseEntity {
    private Date inspectionDate;
    private String inspectionType;
    private int numCritical;
    private int numNoCritical;
    private String HazardRating;
    private String violLump;

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public int getNumCritical() {
        return numCritical;
    }

    public void setNumCritical(int numCritical) {
        this.numCritical = numCritical;
    }

    public int getNumNoCritical() {
        return numNoCritical;
    }

    public void setNumNoCritical(int numNoCritical) {
        this.numNoCritical = numNoCritical;
    }

    public String getHazardRating() {
        return HazardRating;
    }

    public void setHazardRating(String hazardRating) {
        HazardRating = hazardRating;
    }

    public String getViolLump() {
        return violLump;
    }

    public void setViolLump(String violLump) {
        this.violLump = violLump;
    }
}
