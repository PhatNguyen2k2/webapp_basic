//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace De_2.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class DonHang
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public DonHang()
        {
            this.ChiTietDHs = new HashSet<ChiTietDH>();
        }
    
        public string MaDonHang { get; set; }
        public Nullable<System.DateTime> NgayDatHang { get; set; }
        public string MaNguoiDung { get; set; }
        public string DiaChiGiaoHang { get; set; }
        public string PTThanhToan { get; set; }
        public string TinhTrang { get; set; }
        public string TenNguoiNhanHang { get; set; }
        public string SoDienThoaiNhanHang { get; set; }
        public Nullable<long> TongTien { get; set; }
        public Nullable<byte> GiamGia { get; set; }
        public string GhiChu { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ChiTietDH> ChiTietDHs { get; set; }
        public virtual NguoiDung NguoiDung { get; set; }
    }
}
