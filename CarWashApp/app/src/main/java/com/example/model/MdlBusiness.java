package com.example.model;

public class MdlBusiness {

    private int BusinessID;
    private String BusinessTitle;
    private String UserName;
    private String Password;
    private String ContactNo;
   // private boolean isActive;
    private String ImeiNo;
    private int BusinessUser_ID;

    public int getBusinessUser_ID() {
        return BusinessUser_ID;
    }

    public void setBusinessUser_ID(int businessUser_ID) {
        BusinessUser_ID = businessUser_ID;
    }

    public String getImeiNo() {
        return ImeiNo;
    }

    public void setImeiNo(String ImeiNo) {
        this.ImeiNo = ImeiNo;
    }

    public int getBusinessID() {
        return BusinessID;
    }

    public void setBusinessID(int businessID) {
        BusinessID = businessID;
    }

   /* public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
*/
    public String getBusinessTitle() {
        return BusinessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        BusinessTitle = businessTitle;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

}
