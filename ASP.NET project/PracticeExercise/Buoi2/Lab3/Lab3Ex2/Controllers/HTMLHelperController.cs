using Lab3Ex2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Lab3Ex2.Controllers
{
    public class HTMLHelperController : Controller
    {
        // GET: HTMLHelper
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult FormRegister()
        {
            // tạo list cho droplist
            ViewBag.listLoai = new List<Loai>() {
                new Loai(){ID="0",Name="-- Chọn Loại Hình Doanh Nghiệp --"},
                new Loai(){ID="DVSNNN",Name="Đơn Vị Sự Nghiệp Nhà Nước"},
                new Loai(){ID="DVK",Name="Đơn Vị Khác"},
            };
            return View();
        }
        public ActionResult Register()
        {
            // lấy giá trị được các trường đẩy lên server khi submit
            string fvr = "";
            TempData["Name"] = Request["txtName"];
            TempData["Loai"] = Request["Loai"];
            TempData["Number"] = Request["txtNumber"];
            TempData["Address"] = Request["txtAddress"];
            TempData["People"] = Request["txtPeople"];
            TempData["Phone"] = Request["txtPhone"];
            TempData["Fax"] = Request["txtFax"];
            TempData["Email"] = Request["txtEmail"];
            TempData["Website"] = Request["txtWebsite"];
            TempData["UName"] = Request["txtUName"];
            TempData["Pass"] = Request["txtPass"];
            TempData["Checked"] = Request["Checked"].ToString();
            return View();
        }
    }
}