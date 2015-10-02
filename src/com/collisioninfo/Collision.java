package com.collisioninfo;

/**
 * tthis class is a entity bean  of Collision information
 *
 * @author wenyi shen
 * @version 1.0
 */

public class Collision {

    public String date;
    public String time;
    public String borough;
    public String ZIPcode;
    public String lattitude;
    public String longitude;
    public String onstreetname;
    public String crossstreetname;
    public String numberofpersonsinjured;
    public String numberofpersonskilled;
    public String numberofpedestriansinjured;
    public String numberofpedestrianskilled;
    public String numberofcyclistsinjured;
    public String numberofcyclistskilled;
    public String numberofmotoristsinjured;
    public String numberofmotoristskilled;
    public String contributingfactorvehicle1;
    public String contributingfactorvehicle2;
    public String uniquekey;
    public String vehicletypecode1;
    public String vehicletypecode2;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getZIPcode() {
        return ZIPcode;
    }

    public void setZIPcode(String zIPcode) {
        ZIPcode = zIPcode;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOnstreetname() {
        return onstreetname;
    }

    public void setOnstreetname(String onstreetname) {
        this.onstreetname = onstreetname;
    }

    public String getCrossstreetname() {
        return crossstreetname;
    }

    public void setCrossstreetname(String crossstreetname) {
        this.crossstreetname = crossstreetname;
    }

    public String getNumberofpersonsinjured() {
        return numberofpersonsinjured;
    }

    public void setNumberofpersonsinjured(String numberofpersonsinjured) {
        this.numberofpersonsinjured = numberofpersonsinjured;
    }

    public String getNumberofpersonskilled() {
        return numberofpersonskilled;
    }

    public void setNumberofpersonskilled(String numberofpersonskilled) {
        this.numberofpersonskilled = numberofpersonskilled;
    }

    public String getNumberofpedestriansinjured() {
        return numberofpedestriansinjured;
    }

    public void setNumberofpedestriansinjured(String numberofpedestriansinjured) {
        this.numberofpedestriansinjured = numberofpedestriansinjured;
    }

    public String getNumberofpedestrianskilled() {
        return numberofpedestrianskilled;
    }

    public void setNumberofpedestrianskilled(String numberofpedestrianskilled) {
        this.numberofpedestrianskilled = numberofpedestrianskilled;
    }

    public String getNumberofcyclistsinjured() {
        return numberofcyclistsinjured;
    }

    public void setNumberofcyclistsinjured(String numberofcyclistsinjured) {
        this.numberofcyclistsinjured = numberofcyclistsinjured;
    }

    public String getNumberofcyclistskilled() {
        return numberofcyclistskilled;
    }

    public void setNumberofcyclistskilled(String numberofcyclistskilled) {
        this.numberofcyclistskilled = numberofcyclistskilled;
    }

    public String getNumberofmotoristsinjured() {
        return numberofmotoristsinjured;
    }

    public void setNumberofmotoristsinjured(String numberofmotoristsinjured) {
        this.numberofmotoristsinjured = numberofmotoristsinjured;
    }

    public String getNumberofmotoristskilled() {
        return numberofmotoristskilled;
    }

    public void setNumberofmotoristskilled(String numberofmotoristskilled) {
        this.numberofmotoristskilled = numberofmotoristskilled;
    }

    public String getContributingfactorvehicle1() {
        return contributingfactorvehicle1;
    }

    public void setContributingfactorvehicle1(String contributingfactorvehicle1) {
        this.contributingfactorvehicle1 = contributingfactorvehicle1;
    }

    public String getContributingfactorvehicle2() {
        return contributingfactorvehicle2;
    }

    public void setContributingfactorvehicle2(String contributingfactorvehicle2) {
        this.contributingfactorvehicle2 = contributingfactorvehicle2;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getVehicletypecode1() {
        return vehicletypecode1;
    }

    public void setVehicletypecode1(String vehicletypecode1) {
        this.vehicletypecode1 = vehicletypecode1;
    }

    public String getVehicletypecode2() {
        return vehicletypecode2;
    }

    public void setVehicletypecode2(String vehicletypecode2) {
        this.vehicletypecode2 = vehicletypecode2;
    }


    @Override
    public String toString() {
        return "Collision{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", borough='" + borough + '\'' +
                ", ZIPcode='" + ZIPcode + '\'' +
                ", lattitude='" + lattitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", onstreetname='" + onstreetname + '\'' +
                ", crossstreetname='" + crossstreetname + '\'' +
                ", numberofpersonsinjured='" + numberofpersonsinjured + '\'' +
                ", numberofpersonskilled='" + numberofpersonskilled + '\'' +
                ", numberofpedestriansinjured='" + numberofpedestriansinjured + '\'' +
                ", numberofpedestrianskilled='" + numberofpedestrianskilled + '\'' +
                ", numberofcyclistsinjured='" + numberofcyclistsinjured + '\'' +
                ", numberofcyclistskilled='" + numberofcyclistskilled + '\'' +
                ", numberofmotoristsinjured='" + numberofmotoristsinjured + '\'' +
                ", numberofmotoristskilled='" + numberofmotoristskilled + '\'' +
                ", contributingfactorvehicle1='" + contributingfactorvehicle1 + '\'' +
                ", contributingfactorvehicle2='" + contributingfactorvehicle2 + '\'' +
                ", uniquekey='" + uniquekey + '\'' +
                ", vehicletypecode1='" + vehicletypecode1 + '\'' +
                ", vehicletypecode2='" + vehicletypecode2 + '\'' +
                '}';
    }
}
