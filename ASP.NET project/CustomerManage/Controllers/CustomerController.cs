using CustomerManage.App_Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace CustomerManage.Controllers
{
    public class CustomerController : ApiController
    {
        private DuLieuEntity dl = new DuLieuEntity();
        public List<tblKhach> GetAllCustomer()
        {
            System.Console.WriteLine(dl.tblKhaches.ToList());
            return dl.tblKhaches.ToList();
        }
        [HttpGet]
        public tblKhach GetCustomer(string id)
        {
            System.Console.WriteLine(id);
            return dl.tblKhaches.FirstOrDefault(x => x.MaKhach == id);
        }
        [HttpDelete]
        public bool DeleteCustomer(string id)
        {
            tblKhach cus = dl.tblKhaches.FirstOrDefault(x => x.MaKhach == id);
            if (cus == null) return false;
            dl.tblKhaches.Remove(cus);
            dl.SaveChanges();
            return true;
        }
        [HttpPut]
        public bool UpdateCustomer(string id, string name, string address, string phone)
        {
            try
            {
                tblKhach cus = dl.tblKhaches.FirstOrDefault(x => x.MaKhach == id);
                if (cus == null) return false;
                cus.TenKhach = name;
                cus.DiaChi = address;
                cus.DienThoai = phone;
                dl.SaveChanges();
                return true;
            }
            catch (Exception)
            {
                return false;
            }

        }
        [HttpPost]
        public bool InsertCustomer(string id, string name, string address, string phone)
        {
            try
            {
                tblKhach cus = new tblKhach
                {
                    MaKhach = id,
                    TenKhach = name,
                    DiaChi = address,
                    DienThoai = phone
                };
                dl.tblKhaches.Add(cus);
                dl.SaveChanges();
                return true;
            }
            catch (Exception)
            {
                return false;
            }

        }
    }
}
