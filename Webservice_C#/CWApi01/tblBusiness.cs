//------------------------------------------------------------------------------
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
    using System.Collections.Generic;
    
    public partial class tblBusiness
    {
        public tblBusiness()
        {
            this.tblBusinessUsers = new HashSet<tblBusinessUser>();
        }
    
        public long BusinessID { get; set; }
        public string BusinessTitle { get; set; }
        public System.DateTime EntryDate { get; set; }
        public bool isActive { get; set; }
        public System.DateTime isActiveDate { get; set; }
        public int ApprovedByAdminID { get; set; }
        public System.DateTime ApprovedDate { get; set; }
        public int City_ID { get; set; }
        public virtual ICollection<tblBusinessUser> tblBusinessUsers { get; set; }
    }
}