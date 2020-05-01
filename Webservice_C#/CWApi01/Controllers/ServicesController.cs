using CWApi01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace CWApi01.Controllers
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    public class ServicesController : ApiController
    {
        private dbCWEntities1 db = new dbCWEntities1();

        [Route("api/Service/PostServices")]
        [HttpPost]
        public IHttpActionResult PostServices(MdlService s)
        {
            try
            {
                db.usp_InsertService(s.LocalServiceID,s.ServiceType,s.VehicleType,s.VehicleMake,s.Party,s.VehicleModel, s.VehicleReg,s.Commision,s.Amount ,s.CustomerName, s.Contact, s.Comments, s.BusinessUser_ID);
                return Ok();
            }
            catch (Exception)
            {
                throw;
            }
        }

        [HttpGet]
        [Route("api/Service/GetAllServices")]
        public IHttpActionResult GetAllServices()
        {
            List<MdlService> listService = new List<MdlService>();
            listService = db.tblServices.Select(s => new MdlService
            {
                LocalServiceID = s.ServiceID,
                ServiceType = s.ServiceType,
                VehicleType = s.VehicleType,
                VehicleMake = s.VehicleMake,
                Party = s.Party,
                VehicleModel = s.VehicleModel,
                VehicleReg = s.VehicleReg,
                Commision = s.Commision,
                Amount = s.Amount,
                CustomerName = s.CustomerName,
                Contact = s.Contact,
                Comments = s.Comments,
                CurrentDate = s.CurrentDate,
                CurrentTime = s.CurrentTime,
                BusinessUser_ID = s.BusinessUser_ID
            }).ToList();
            return Ok(listService);
        }

        [Route("api/Service/GetServices/{id}")]
        public IHttpActionResult GetServices(long id)
        {
            MdlService mService = new MdlService();
            mService = db.tblServices.Select(s => new MdlService
            {
                LocalServiceID = s.ServiceID,
                ServiceType = s.ServiceType,
                VehicleType = s.VehicleType,
                VehicleMake = s.VehicleMake,
                Party = s.Party,
                VehicleModel = s.VehicleModel,
                VehicleReg = s.VehicleReg,
                Commision = s.Commision,
                Amount = s.Amount,
                CustomerName = s.CustomerName,
                Contact = s.Contact,
                Comments = s.Comments,
                CurrentDate = s.CurrentDate,
                CurrentTime = s.CurrentTime,
                BusinessUser_ID = s.BusinessUser_ID
            }).FirstOrDefault(sKey => sKey.LocalServiceID == id);
            return Ok(mService);
        }
    }
}
