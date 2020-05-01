package com.example.model;

public class Services {

    public  int  LocalServiceID;
    public  String  VehicleMake;
    public  String  VehicleModel;
    public  String  VehicleReg;
    public  String  VehicleType;
    public  String  CustomerName;
    public  String  Contact;
    public  String  ServiceType;
    public  String  Commision;
    public  String  Amount;
    public  String  initAmount;
    public  String  Party;
    public  String  Comments;
    public  String  vDate;
    public  String  vTime;
    public  int  Business_ID;
    public  int  isUpload;

    public int getBusiness_ID() {
        return Business_ID;
    }

    public void setBusiness_ID(int business_ID) {
        Business_ID = business_ID;
    }

    public int getisUpload() {
        return isUpload;
    }

    public void setisUpload(int upload) {
        isUpload = upload;
    }



  //String isUpload
  /*  public  String  isUpload;
    public String getIsUpload() {
        return isUpload;
    }
    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }
*/

    public Services(int vehicleID, String vehicleMake, String vehicleModel, String vehicleReg, String vehicleType, String customerName, String contact, String serviceType, String commision, String amount, String party, String comments, String vDate, String vTime) {
        LocalServiceID = vehicleID;
        VehicleMake = vehicleMake;
        VehicleModel = vehicleModel;
        VehicleReg = vehicleReg;
        VehicleType = vehicleType;
        CustomerName = customerName;
        Contact = contact;
        ServiceType = serviceType;
        Commision = commision;
        Amount = amount;
        Party = party;
        Comments = comments;
        this.vDate = vDate;
        this.vTime = vTime;
    }


    public Services() {
    }

    public String getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(String initAmount) {
        this.initAmount = initAmount;
    }

    public String getvDate() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
    }

    public String getvTime() {
        return vTime;
    }

    public void setvTime(String vTime) {
        this.vTime = vTime;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getCommision() {
        return Commision;
    }

    public void setCommision(String commision) {
        Commision = commision;
    }


    public int getLocalServiceID() {
        return LocalServiceID;
    }

    public void setLocalServiceID(int vehicleID) {
        LocalServiceID = vehicleID;
    }

    public String getVehicleMake() {
        return VehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        VehicleMake = vehicleMake;
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

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getParty() {
        return Party;
    }

    public void setParty(String party) {
        Party = party;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }


}
