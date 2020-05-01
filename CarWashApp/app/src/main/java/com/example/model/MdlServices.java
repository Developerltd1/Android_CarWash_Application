package com.example.model;

import java.math.BigDecimal;

public class MdlServices {

    private long ServiceID;
    private String ServiceType;
    private String VehicleType;
    private String VehicleMake;
    private String Party;
    private String VehicleModel;
    private String VehicleReg;
    private BigDecimal Commision;
    private BigDecimal Amount;
    private String CustomerName;
    private String Contact;
    private String Comments;
    private String CurrentDate;
    private String CurrentTime;
    private int Business_ID;

    public BigDecimal getCommision() {
        return Commision;
    }

    public void setCommision(BigDecimal commision) {
        Commision = commision;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public long getServiceID() {
        return ServiceID;
    }

    public void setServiceID(long serviceID) {
        ServiceID = serviceID;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVehicleMake() {
        return VehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        VehicleMake = vehicleMake;
    }

    public String getParty() {
        return Party;
    }

    public void setParty(String party) {
        Party = party;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        VehicleModel = vehicleModel;
    }

    public String getVehicleReg() {
        return VehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        VehicleReg = vehicleReg;
    }



    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }

    public String getCurrentTime() {
        return CurrentTime;
    }

    public void setCurrentTime(String currentTime) {
        CurrentTime = currentTime;
    }

    public int getBusiness_ID() {
        return Business_ID;
    }

    public void setBusiness_ID(int business_ID) {
        Business_ID = business_ID;
    }
}
