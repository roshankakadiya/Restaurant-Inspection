package com.example.cmpt276group05.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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


    public String adjustTime(){

//        Date now = inspectionDate;
//        long diffInMillies = Math.abs(Objects.requireNonNull(date.getTime() - now.getTime()));
//        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//
//        Date date = Calendar.getInstance().getTime();
//        DateFormat monthformat = new SimpleDateFormat("MMMM");
//        DateFormat dayformat = new SimpleDateFormat("dd");
//        String month;
//        String days;
//
//        if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }else if(monthformat.equals("1") && monthformat.equals("01")){
//            month = "Jan";
//        }
//        String strDate = dateFormat.format(date);
//
//        String output = null;
//        if(diff < 30) {
//            output = diff + " days ago";
//        }
//        else if(diff < 365) {
//            if(diff == 1)
//                output = ;
//            else
//                output = ;
//        }
//        else {
//            if((int) (diff / (60 * 24)) == 1)
//                output = "About " + (int) (diff / (60 * 24)) + " day ago";
//            else
//                output = "About " + (int) (diff / (60 * 24)) + " days ago";
//        }
//        return output;

        return "adasdasd";
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
