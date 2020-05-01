using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CWApi01.Models
{
    public class MdlService
    {
        public long LocalServiceID { get; set; }
        public string ServiceType { get; set; }
        public string VehicleType { get; set; }
        public string VehicleMake { get; set; }
        public string Party { get; set; }
        public string VehicleModel { get; set; }
        public string VehicleReg { get; set; }
        public decimal Commision { get; set; }
        public decimal Amount { get; set; }
        public string CustomerName { get; set; }
        public string Contact { get; set; }
        public string Comments { get; set; }
        public DateTime CurrentDate { get; set; }
        public DateTime CurrentTime { get; set; }
        public long BusinessUser_ID { get; set; }
    }
}