using Lab2Bai3.Models;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using System.IO;

namespace Lab2Bai3.Controllers
{
    public class ProductController : Controller
    {
        private object db;

        public string Name { get; set; }

        public List<Product> GetProducts()
        {
            List<Product> list = new List<Product>();
            list.Add(new Product() { Name = "AiHayChuNgo-LamChan-Khang" });
            list.Add(new Product() { Name = "AiRoiCungKhac-HamletTruong" });
            list.Add(new Product() { Name = "Anh O Dau-Trang Phap" });
            list.Add(new Product() { Name = "AnhBiet-HoQuangHieu" });
            list.Add(new Product() { Name = "AnhBiet-Tim" });
            list.Add(new Product() { Name = "AnhGhetLamBanEm-PhanManhQuynh" });
            list.Add(new Product() { Name = "AnhCanEm-KhacViet" });
            list.Add(new Product() { Name = "AnhCanEmNghe-KhacViet" });
            list.Add(new Product() { Name = "AnhChiLaNguoiEmTungYeu-KhacAnh" });
            list.Add(new Product() { Name = "AnhChiLaNguoiEmTungYeu-KhacAnh" });
            list.Add(new Product() { Name = "AnhDaSai-OnlyC" });
            return list;
        }
        // GET: Product
        public ActionResult ShowProduct()
        {
            var listProduct = GetProducts();
            var Product = new Product();
            Product.productList = listProduct;
            return View(Product);
        }
        // GET: Chi tiết sản phẩm
        public ActionResult DetailsProduct(string Name)
        {
            ViewBag.Name = Name;
            return View();


        }
        public FilePathResult TestFilePathResult(string Name)
        {
            ViewBag.Name = Name;
            string pathFile = Server.MapPath("~/Content/" + Name + ".mp3");
            string fileName = Name + ".mp3";
            return File(pathFile, "mp3", fileName);
        }
        public FilePathResult TestFilePathResult1(string Name)
        {
            ViewBag.Name = Name;
            string pathFile = Server.MapPath("~/Content/" + Name + ".mp3");
            string fileName = Name + ".mp3";
            return File(pathFile, "mp3", fileName);
        }

        internal struct NewStruct
        {
            public object Item1;
            public object Item2;

            public NewStruct(object item1, object item2)
            {
                Item1 = item1;
                Item2 = item2;
            }

            public override bool Equals(object obj)
            {
                return obj is NewStruct other &&
                       EqualityComparer<object>.Default.Equals(Item1, other.Item1) &&
                       EqualityComparer<object>.Default.Equals(Item2, other.Item2);
            }

            public override int GetHashCode()
            {
                int hashCode = -1030903623;
                hashCode = hashCode * -1521134295 + EqualityComparer<object>.Default.GetHashCode(Item1);
                hashCode = hashCode * -1521134295 + EqualityComparer<object>.Default.GetHashCode(Item2);
                return hashCode;
            }

            public void Deconstruct(out object item1, out object item2)
            {
                item1 = Item1;
                item2 = Item2;
            }

            public static implicit operator (object, object)(NewStruct value)
            {
                return (value.Item1, value.Item2);
            }

            public static implicit operator NewStruct((object, object) value)
            {
                return new NewStruct(value.Item1, value.Item2);
            }
        }
    }
}