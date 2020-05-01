using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using CWApi01.Models;
using System.Web.Http.Cors;

namespace CWApi01.Controllers
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]

    //[RoutePrefix("api/Business")]
    public class BusinessController : ApiController
    {
        private dbCWEntities1 db = new dbCWEntities1();

        [HttpPost]
        [Route("api/Business/PostBusiness")]
        public IHttpActionResult PostBusiness(MdlBusiness b)
        {
            try
            {
                System.Data.Objects.ObjectParameter BusinessID = new System.Data.Objects.ObjectParameter("Businessid", typeof(Int64));
                System.Data.Objects.ObjectParameter BusinessUser_ID = new System.Data.Objects.ObjectParameter("BusinessUser_Id", typeof(Int32));
                // calling sp
                db.usp_InsertBusiness(b.BusinessTitle, b.ImeNumber,b.UserName, b.Password, b.ContactNo, BusinessID, BusinessUser_ID);
               
                b.BusinessID = Convert.ToInt64(BusinessID.Value);
                b.BusinessUserID = Convert.ToInt32(BusinessUser_ID.Value);

                return Ok(b);
            }
            catch (Exception)
            {
                throw;
            }
        }

 /*       [HttpPost]
        [Route("api/Business/PostBusiness")]
        public MdlBusiness PostBusiness(MdlBusiness b)
        {
            try
            {
                System.Data.Objects.ObjectParameter BusinessID = new System.Data.Objects.ObjectParameter("Businessid", typeof(Int64));
                System.Data.Objects.ObjectParameter BusinessUser_ID = new System.Data.Objects.ObjectParameter("BusinessUser_Id", typeof(Int32));
                // calling sp
                db.usp_InsertBusiness(b.BusinessTitle, b.ImeNumber, b.UserName, b.Password, b.ContactNo, BusinessID, BusinessUser_ID);

                b.BusinessID = Convert.ToInt64(BusinessID.Value);
                b.BusinessUserID = Convert.ToInt32(BusinessUser_ID.Value);


                return b;
            }
            catch (Exception)
            {
                throw;
            }
        }

*/


        [HttpGet]
        [Route("api/Business/GetBusiness/{id}")]
        public IHttpActionResult GetBusiness(long id)
        {

            MdlBusiness modelBusiness = new MdlBusiness();
            modelBusiness = db.tblBusinesses.Select(w => new MdlBusiness { BusinessID = w.BusinessID, BusinessTitle = w.BusinessTitle }).FirstOrDefault(w => w.BusinessID == id);
            return Ok(modelBusiness);
        }

        [HttpGet]
        [Route("api/Business/GetAllBusinesses")]
        public IHttpActionResult GetAllBusinesses()
        {
            List<MdlBusiness> modelBusiness = new List<MdlBusiness>();
            modelBusiness = db.tblBusinesses.Select(w => new MdlBusiness
            {
                BusinessID = w.BusinessID,
                BusinessTitle = w.BusinessTitle
            }
            ).ToList();
            return Ok(modelBusiness);
        }
    }
}
