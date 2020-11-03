package com.example.cmpt276group05.model;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/*
 * Data Class for Inspection
 */

public class Inspection {
    private String trackingNumber;
    private Date inspectionDate;
    private String inspectionType;
    private int numCritViolations;
    private int numNonCritViolations;
    private String hazardRating;
    private String violationReport;



    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

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

    public int getNumCritViolations() {
        return numCritViolations;
    }

    public void setNumCritViolations(int numCritViolations) {
        this.numCritViolations = numCritViolations;
    }

    public int getNumNonCritViolations() {
        return numNonCritViolations;
    }

    public void setNumNonCritViolations(int numNonCritViolations) {
        this.numNonCritViolations = numNonCritViolations;
    }

    public String getHazardRating() {
        return hazardRating;
    }

    public void setHazardRating(String hazardRating) {
        this.hazardRating = hazardRating;
    }

    public String getViolationReport() {
        return violationReport;
    }

    public void setViolationReport(String violationReport) {
        this.violationReport = violationReport;
    }

    public String adjustTime(Date date){

        Date now = new Date();
        long diffInMillies = Math.abs(Objects.requireNonNull(date.getTime() - now.getTime()));
        long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);

        String timeInfo = null;
        if(diff < 60) {
            if(diff == 1)
                timeInfo = "About " + diff + " minute ago";
            else
                timeInfo = "About " + diff + " minutes ago";
        }
        else if((diff / 60) < 24) {
            if((int) (diff / 60) == 1)
                timeInfo = "About " + (int) (diff / 60) + " hour ago";
            else
                timeInfo = "About " + (int) (diff / 60) + " hours ago";
        }
        else {
            if((int) (diff / (60 * 24)) == 1)
                timeInfo = "About " + (int) (diff / (60 * 24)) + " day ago";
            else
                timeInfo = "About " + (int) (diff / (60 * 24)) + " days ago";
        }
        return timeInfo;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "trackingNumber='" + trackingNumber + '\'' +
                ", inspectionDate=" + inspectionDate +
                ", inspectionType='" + inspectionType + '\'' +
                ", numCritViolations=" + numCritViolations +
                ", numNonCritViolations=" + numNonCritViolations +
                ", hazardRating='" + hazardRating + '\'' +
                ", violationReport='" + violationReport + '\'' +
                '}';
    }
}
