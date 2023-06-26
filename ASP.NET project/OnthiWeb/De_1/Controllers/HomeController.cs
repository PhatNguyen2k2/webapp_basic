using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using De_1.Models;
namespace De_1.Controllers
{
    public class HomeController : Controller
    {
        QLBanHangQuanAoEntities db = new QLBanHangQuanAoEntities();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult RenderNav()
        {
            List<PhanLoai> listLoai = db.PhanLoais.ToList();
            return PartialView("Header", listLoai);
        }
        public ActionResult RenderProduct()
        {
            List<SanPham> listSp = db.SanPhams.ToList();
            return PartialView("Main_Content", listSp);
        }
        public ActionResult RenderProductByCatId(string CatId)
        {
            List<SanPham> listPro = db.SanPhams.Where(p => p.MaPhanLoai == CatId).ToList();

            return PartialView("Main_Content", listPro);
        }
        // GET: SanPhams/Create
        public ActionResult Create()
        {
            ViewBag.MaPhanLoai = new SelectList(db.PhanLoais, "MaPhanLoai", "PhanLoaiChinh");
            ViewBag.MaPhanLoaiPhu = new SelectList(db.PhanLoaiPhus, "MaPhanLoaiPhu", "TenPhanLoaiPhu");
            return View();
        }

        // POST: SanPhams/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "MaSanPham,TenSanPham,MaPhanLoai,GiaNhap,DonGiaBanNhoNhat,DonGiaBanLonNhat,TrangThai,MoTaNgan,AnhDaiDien,NoiBat,MaPhanLoaiPhu")] SanPham sanPham)
        {
            if (ModelState.IsValid)
            {
                db.SanPhams.Add(sanPham);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.MaPhanLoai = new SelectList(db.PhanLoais, "MaPhanLoai", "PhanLoaiChinh", sanPham.MaPhanLoai);
            ViewBag.MaPhanLoaiPhu = new SelectList(db.PhanLoaiPhus, "MaPhanLoaiPhu", "TenPhanLoaiPhu", sanPham.MaPhanLoaiPhu);
            return View(sanPham);
        }

    }
}