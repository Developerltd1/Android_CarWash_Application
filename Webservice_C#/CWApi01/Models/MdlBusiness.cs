using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CWApi01.Models
{
    public class MdlBusiness
    {
        public long BusinessID { get; set; }
        public string BusinessTitle { get; set; }
        public string ImeNumber { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string ContactNo { get; set; }
        public DateTime EntryDate { get; set; }
        public Boolean isActive { get; set; }
        public DateTime isActiveDate { get; set; }
        public int ApprovedByUser_ID { get; set; }
        public DateTime ApprovedDate { get; set; }
        public int City_ID { get; set; }

        public int BusinessUserID { get; set; }
        //public MdlBusiness() { }

        //public MdlBusiness(long BusinessID, string BusinessTitle, string ImeNumber, string UserName,
        //    string Password, string ContactNo, DateTime EntryDate, Boolean isActive, DateTime isActiveDate,
        //    int ApprovedByUser_ID, DateTime ApprovedDate, int City_ID)
        //{
        //    this.BusinessID = BusinessID;
        //    this.BusinessTitle = BusinessTitle;
        //    this.ImeNumber = ImeNumber;
        //    this.UserName = UserName;
        //    this.Password = Password;
        //    this.ContactNo = ContactNo;
        //    this.EntryDate = EntryDate;
        //    this.isActive = isActive;
        //    this.isActiveDate = isActiveDate;
        //    this.ApprovedByUser_ID = ApprovedByUser_ID;
        //    this.ApprovedDate = ApprovedDate;
        //    this.City_ID = City_ID;
        //}
    }
}