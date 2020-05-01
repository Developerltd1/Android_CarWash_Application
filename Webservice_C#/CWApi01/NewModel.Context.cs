﻿//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace CWApi01
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Data.Objects;
    using System.Data.Objects.DataClasses;
    using System.Linq;
    
    public partial class dbCWEntities1 : DbContext
    {
        public dbCWEntities1()
            : base("name=dbCWEntities1")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public DbSet<sysdiagram> sysdiagrams { get; set; }
        public DbSet<tblBusiness> tblBusinesses { get; set; }
        public DbSet<tblBusinessUser> tblBusinessUsers { get; set; }
        public DbSet<tblService> tblServices { get; set; }
    
        public virtual int sp_alterdiagram(string diagramname, Nullable<int> owner_id, Nullable<int> version, byte[] definition)
        {
            var diagramnameParameter = diagramname != null ?
                new ObjectParameter("diagramname", diagramname) :
                new ObjectParameter("diagramname", typeof(string));
    
            var owner_idParameter = owner_id.HasValue ?
                new ObjectParameter("owner_id", owner_id) :
                new ObjectParameter("owner_id", typeof(int));
    
            var versionParameter = version.HasValue ?
                new ObjectParameter("version", version) :
                new ObjectParameter("version", typeof(int));
    
            var definitionParameter = definition != null ?
                new ObjectParameter("definition", definition) :
                new ObjectParameter("definition", typeof(byte[]));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("sp_alterdiagram", diagramnameParameter, owner_idParameter, versionParameter, definitionParameter);
        }
    
        public virtual int sp_creatediagram(string diagramname, Nullable<int> owner_id, Nullable<int> version, byte[] definition)
        {
            var diagramnameParameter = diagramname != null ?
                new ObjectParameter("diagramname", diagramname) :
                new ObjectParameter("diagramname", typeof(string));
    
            var owner_idParameter = owner_id.HasValue ?
                new ObjectParameter("owner_id", owner_id) :
                new ObjectParameter("owner_id", typeof(int));
    
            var versionParameter = version.HasValue ?
                new ObjectParameter("version", version) :
                new ObjectParameter("version", typeof(int));
    
            var definitionParameter = definition != null ?
                new ObjectParameter("definition", definition) :
                new ObjectParameter("definition", typeof(byte[]));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("sp_creatediagram", diagramnameParameter, owner_idParameter, versionParameter, definitionParameter);
        }
    
        public virtual int sp_dropdiagram(string diagramname, Nullable<int> owner_id)
        {
            var diagramnameParameter = diagramname != null ?
                new ObjectParameter("diagramname", diagramname) :
                new ObjectParameter("diagramname", typeof(string));
    
            var owner_idParameter = owner_id.HasValue ?
                new ObjectParameter("owner_id", owner_id) :
                new ObjectParameter("owner_id", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("sp_dropdiagram", diagramnameParameter, owner_idParameter);
        }
    
        public virtual ObjectResult<sp_helpdiagramdefinition_Result> sp_helpdiagramdefinition(string diagramname, Nullable<int> owner_id)
        {
            var diagramnameParameter = diagramname != null ?
                new ObjectParameter("diagramname", diagramname) :
                new ObjectParameter("diagramname", typeof(string));
    
            var owner_idParameter = owner_id.HasValue ?
                new ObjectParameter("owner_id", owner_id) :
                new ObjectParameter("owner_id", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction<sp_helpdiagramdefinition_Result>("sp_helpdiagramdefinition", diagramnameParameter, owner_idParameter);
        }
    
        public virtual ObjectResult<sp_helpdiagrams_Result> sp_helpdiagrams(string diagramname, Nullable<int> owner_id)
        {
            var diagramnameParameter = diagramname != null ?
                new ObjectParameter("diagramname", diagramname) :
                new ObjectParameter("diagramname", typeof(string));
    
            var owner_idParameter = owner_id.HasValue ?
                new ObjectParameter("owner_id", owner_id) :
                new ObjectParameter("owner_id", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction<sp_helpdiagrams_Result>("sp_helpdiagrams", diagramnameParameter, owner_idParameter);
        }
    
        public virtual int sp_renamediagram(string diagramname, Nullable<int> owner_id, string new_diagramname)
        {
            var diagramnameParameter = diagramname != null ?
                new ObjectParameter("diagramname", diagramname) :
                new ObjectParameter("diagramname", typeof(string));
    
            var owner_idParameter = owner_id.HasValue ?
                new ObjectParameter("owner_id", owner_id) :
                new ObjectParameter("owner_id", typeof(int));
    
            var new_diagramnameParameter = new_diagramname != null ?
                new ObjectParameter("new_diagramname", new_diagramname) :
                new ObjectParameter("new_diagramname", typeof(string));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("sp_renamediagram", diagramnameParameter, owner_idParameter, new_diagramnameParameter);
        }
    
        public virtual int sp_upgraddiagrams()
        {
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("sp_upgraddiagrams");
        }
    
        public virtual int usp_InsertBusiness(string businessTitle, string imeNumber, string userName, string password, string contactNo, ObjectParameter businessid, ObjectParameter businessUser_ID)
        {
            var businessTitleParameter = businessTitle != null ?
                new ObjectParameter("BusinessTitle", businessTitle) :
                new ObjectParameter("BusinessTitle", typeof(string));
    
            var imeNumberParameter = imeNumber != null ?
                new ObjectParameter("ImeNumber", imeNumber) :
                new ObjectParameter("ImeNumber", typeof(string));
    
            var userNameParameter = userName != null ?
                new ObjectParameter("UserName", userName) :
                new ObjectParameter("UserName", typeof(string));
    
            var passwordParameter = password != null ?
                new ObjectParameter("Password", password) :
                new ObjectParameter("Password", typeof(string));
    
            var contactNoParameter = contactNo != null ?
                new ObjectParameter("ContactNo", contactNo) :
                new ObjectParameter("ContactNo", typeof(string));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_InsertBusiness", businessTitleParameter, imeNumberParameter, userNameParameter, passwordParameter, contactNoParameter, businessid, businessUser_ID);
        }
    
        public virtual int usp_InsertNewUser(Nullable<int> business_ID, string imeNumber, string userName, string password, string contactNo, ObjectParameter businessUser_ID)
        {
            var business_IDParameter = business_ID.HasValue ?
                new ObjectParameter("Business_ID", business_ID) :
                new ObjectParameter("Business_ID", typeof(int));
    
            var imeNumberParameter = imeNumber != null ?
                new ObjectParameter("ImeNumber", imeNumber) :
                new ObjectParameter("ImeNumber", typeof(string));
    
            var userNameParameter = userName != null ?
                new ObjectParameter("UserName", userName) :
                new ObjectParameter("UserName", typeof(string));
    
            var passwordParameter = password != null ?
                new ObjectParameter("Password", password) :
                new ObjectParameter("Password", typeof(string));
    
            var contactNoParameter = contactNo != null ?
                new ObjectParameter("ContactNo", contactNo) :
                new ObjectParameter("ContactNo", typeof(string));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_InsertNewUser", business_IDParameter, imeNumberParameter, userNameParameter, passwordParameter, contactNoParameter, businessUser_ID);
        }
    
        public virtual int usp_InsertPayment(Nullable<System.DateTime> paymentDate, string paymentComments, Nullable<int> paymentMode, Nullable<int> paymentType, Nullable<bool> isActive, Nullable<int> user_ID)
        {
            var paymentDateParameter = paymentDate.HasValue ?
                new ObjectParameter("PaymentDate", paymentDate) :
                new ObjectParameter("PaymentDate", typeof(System.DateTime));
    
            var paymentCommentsParameter = paymentComments != null ?
                new ObjectParameter("PaymentComments", paymentComments) :
                new ObjectParameter("PaymentComments", typeof(string));
    
            var paymentModeParameter = paymentMode.HasValue ?
                new ObjectParameter("PaymentMode", paymentMode) :
                new ObjectParameter("PaymentMode", typeof(int));
    
            var paymentTypeParameter = paymentType.HasValue ?
                new ObjectParameter("PaymentType", paymentType) :
                new ObjectParameter("PaymentType", typeof(int));
    
            var isActiveParameter = isActive.HasValue ?
                new ObjectParameter("isActive", isActive) :
                new ObjectParameter("isActive", typeof(bool));
    
            var user_IDParameter = user_ID.HasValue ?
                new ObjectParameter("User_ID", user_ID) :
                new ObjectParameter("User_ID", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_InsertPayment", paymentDateParameter, paymentCommentsParameter, paymentModeParameter, paymentTypeParameter, isActiveParameter, user_IDParameter);
        }
    
        public virtual int usp_InsertService(Nullable<long> localServiceID, string serviceType, string vehicleType, string vehicleMake, string party, string vehicleModel, string vehicleReg, Nullable<decimal> commision, Nullable<decimal> amount, string customerName, string contact, string comments, Nullable<long> businessUser_ID)
        {
            var localServiceIDParameter = localServiceID.HasValue ?
                new ObjectParameter("LocalServiceID", localServiceID) :
                new ObjectParameter("LocalServiceID", typeof(long));
    
            var serviceTypeParameter = serviceType != null ?
                new ObjectParameter("ServiceType", serviceType) :
                new ObjectParameter("ServiceType", typeof(string));
    
            var vehicleTypeParameter = vehicleType != null ?
                new ObjectParameter("VehicleType", vehicleType) :
                new ObjectParameter("VehicleType", typeof(string));
    
            var vehicleMakeParameter = vehicleMake != null ?
                new ObjectParameter("VehicleMake", vehicleMake) :
                new ObjectParameter("VehicleMake", typeof(string));
    
            var partyParameter = party != null ?
                new ObjectParameter("Party", party) :
                new ObjectParameter("Party", typeof(string));
    
            var vehicleModelParameter = vehicleModel != null ?
                new ObjectParameter("VehicleModel", vehicleModel) :
                new ObjectParameter("VehicleModel", typeof(string));
    
            var vehicleRegParameter = vehicleReg != null ?
                new ObjectParameter("VehicleReg", vehicleReg) :
                new ObjectParameter("VehicleReg", typeof(string));
    
            var commisionParameter = commision.HasValue ?
                new ObjectParameter("Commision", commision) :
                new ObjectParameter("Commision", typeof(decimal));
    
            var amountParameter = amount.HasValue ?
                new ObjectParameter("Amount", amount) :
                new ObjectParameter("Amount", typeof(decimal));
    
            var customerNameParameter = customerName != null ?
                new ObjectParameter("CustomerName", customerName) :
                new ObjectParameter("CustomerName", typeof(string));
    
            var contactParameter = contact != null ?
                new ObjectParameter("Contact", contact) :
                new ObjectParameter("Contact", typeof(string));
    
            var commentsParameter = comments != null ?
                new ObjectParameter("Comments", comments) :
                new ObjectParameter("Comments", typeof(string));
    
            var businessUser_IDParameter = businessUser_ID.HasValue ?
                new ObjectParameter("BusinessUser_ID", businessUser_ID) :
                new ObjectParameter("BusinessUser_ID", typeof(long));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_InsertService", localServiceIDParameter, serviceTypeParameter, vehicleTypeParameter, vehicleMakeParameter, partyParameter, vehicleModelParameter, vehicleRegParameter, commisionParameter, amountParameter, customerNameParameter, contactParameter, commentsParameter, businessUser_IDParameter);
        }
    
        public virtual int usp_InsertUser(Nullable<bool> userType, string userName, string userContact, string userAddress, string userCNIC, string userPassportNo, string userDesignation, string userPMDCNo, Nullable<System.DateTime> userJoiningDate, Nullable<System.DateTime> userLeavingDate, Nullable<bool> isActive, Nullable<System.DateTime> userApplyDate)
        {
            var userTypeParameter = userType.HasValue ?
                new ObjectParameter("UserType", userType) :
                new ObjectParameter("UserType", typeof(bool));
    
            var userNameParameter = userName != null ?
                new ObjectParameter("UserName", userName) :
                new ObjectParameter("UserName", typeof(string));
    
            var userContactParameter = userContact != null ?
                new ObjectParameter("UserContact", userContact) :
                new ObjectParameter("UserContact", typeof(string));
    
            var userAddressParameter = userAddress != null ?
                new ObjectParameter("UserAddress", userAddress) :
                new ObjectParameter("UserAddress", typeof(string));
    
            var userCNICParameter = userCNIC != null ?
                new ObjectParameter("UserCNIC", userCNIC) :
                new ObjectParameter("UserCNIC", typeof(string));
    
            var userPassportNoParameter = userPassportNo != null ?
                new ObjectParameter("UserPassportNo", userPassportNo) :
                new ObjectParameter("UserPassportNo", typeof(string));
    
            var userDesignationParameter = userDesignation != null ?
                new ObjectParameter("UserDesignation", userDesignation) :
                new ObjectParameter("UserDesignation", typeof(string));
    
            var userPMDCNoParameter = userPMDCNo != null ?
                new ObjectParameter("UserPMDCNo", userPMDCNo) :
                new ObjectParameter("UserPMDCNo", typeof(string));
    
            var userJoiningDateParameter = userJoiningDate.HasValue ?
                new ObjectParameter("UserJoiningDate", userJoiningDate) :
                new ObjectParameter("UserJoiningDate", typeof(System.DateTime));
    
            var userLeavingDateParameter = userLeavingDate.HasValue ?
                new ObjectParameter("UserLeavingDate", userLeavingDate) :
                new ObjectParameter("UserLeavingDate", typeof(System.DateTime));
    
            var isActiveParameter = isActive.HasValue ?
                new ObjectParameter("IsActive", isActive) :
                new ObjectParameter("IsActive", typeof(bool));
    
            var userApplyDateParameter = userApplyDate.HasValue ?
                new ObjectParameter("UserApplyDate", userApplyDate) :
                new ObjectParameter("UserApplyDate", typeof(System.DateTime));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_InsertUser", userTypeParameter, userNameParameter, userContactParameter, userAddressParameter, userCNICParameter, userPassportNoParameter, userDesignationParameter, userPMDCNoParameter, userJoiningDateParameter, userLeavingDateParameter, isActiveParameter, userApplyDateParameter);
        }
    
        public virtual int usp_UpdatePayment(Nullable<int> paymentID, Nullable<System.DateTime> paymentDate, string paymentComments, Nullable<int> paymentMode, Nullable<int> paymentType, Nullable<bool> isActive, Nullable<int> user_ID)
        {
            var paymentIDParameter = paymentID.HasValue ?
                new ObjectParameter("PaymentID", paymentID) :
                new ObjectParameter("PaymentID", typeof(int));
    
            var paymentDateParameter = paymentDate.HasValue ?
                new ObjectParameter("PaymentDate", paymentDate) :
                new ObjectParameter("PaymentDate", typeof(System.DateTime));
    
            var paymentCommentsParameter = paymentComments != null ?
                new ObjectParameter("PaymentComments", paymentComments) :
                new ObjectParameter("PaymentComments", typeof(string));
    
            var paymentModeParameter = paymentMode.HasValue ?
                new ObjectParameter("PaymentMode", paymentMode) :
                new ObjectParameter("PaymentMode", typeof(int));
    
            var paymentTypeParameter = paymentType.HasValue ?
                new ObjectParameter("PaymentType", paymentType) :
                new ObjectParameter("PaymentType", typeof(int));
    
            var isActiveParameter = isActive.HasValue ?
                new ObjectParameter("isActive", isActive) :
                new ObjectParameter("isActive", typeof(bool));
    
            var user_IDParameter = user_ID.HasValue ?
                new ObjectParameter("User_ID", user_ID) :
                new ObjectParameter("User_ID", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_UpdatePayment", paymentIDParameter, paymentDateParameter, paymentCommentsParameter, paymentModeParameter, paymentTypeParameter, isActiveParameter, user_IDParameter);
        }
    
        public virtual int usp_UpdateUser(Nullable<int> userID, Nullable<bool> userType, string userName, string userContact, string userAddress, string userCNIC, string userPassportNo, string userDesignation, string userPMDCNo, Nullable<System.DateTime> userJoiningDate, Nullable<System.DateTime> userLeavingDate, Nullable<bool> isActive, Nullable<System.DateTime> userApplyDate)
        {
            var userIDParameter = userID.HasValue ?
                new ObjectParameter("UserID", userID) :
                new ObjectParameter("UserID", typeof(int));
    
            var userTypeParameter = userType.HasValue ?
                new ObjectParameter("UserType", userType) :
                new ObjectParameter("UserType", typeof(bool));
    
            var userNameParameter = userName != null ?
                new ObjectParameter("UserName", userName) :
                new ObjectParameter("UserName", typeof(string));
    
            var userContactParameter = userContact != null ?
                new ObjectParameter("UserContact", userContact) :
                new ObjectParameter("UserContact", typeof(string));
    
            var userAddressParameter = userAddress != null ?
                new ObjectParameter("UserAddress", userAddress) :
                new ObjectParameter("UserAddress", typeof(string));
    
            var userCNICParameter = userCNIC != null ?
                new ObjectParameter("UserCNIC", userCNIC) :
                new ObjectParameter("UserCNIC", typeof(string));
    
            var userPassportNoParameter = userPassportNo != null ?
                new ObjectParameter("UserPassportNo", userPassportNo) :
                new ObjectParameter("UserPassportNo", typeof(string));
    
            var userDesignationParameter = userDesignation != null ?
                new ObjectParameter("UserDesignation", userDesignation) :
                new ObjectParameter("UserDesignation", typeof(string));
    
            var userPMDCNoParameter = userPMDCNo != null ?
                new ObjectParameter("UserPMDCNo", userPMDCNo) :
                new ObjectParameter("UserPMDCNo", typeof(string));
    
            var userJoiningDateParameter = userJoiningDate.HasValue ?
                new ObjectParameter("UserJoiningDate", userJoiningDate) :
                new ObjectParameter("UserJoiningDate", typeof(System.DateTime));
    
            var userLeavingDateParameter = userLeavingDate.HasValue ?
                new ObjectParameter("UserLeavingDate", userLeavingDate) :
                new ObjectParameter("UserLeavingDate", typeof(System.DateTime));
    
            var isActiveParameter = isActive.HasValue ?
                new ObjectParameter("IsActive", isActive) :
                new ObjectParameter("IsActive", typeof(bool));
    
            var userApplyDateParameter = userApplyDate.HasValue ?
                new ObjectParameter("UserApplyDate", userApplyDate) :
                new ObjectParameter("UserApplyDate", typeof(System.DateTime));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("usp_UpdateUser", userIDParameter, userTypeParameter, userNameParameter, userContactParameter, userAddressParameter, userCNICParameter, userPassportNoParameter, userDesignationParameter, userPMDCNoParameter, userJoiningDateParameter, userLeavingDateParameter, isActiveParameter, userApplyDateParameter);
        }
    }
}
