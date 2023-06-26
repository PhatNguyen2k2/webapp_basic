using System.Collections.Generic;


namespace Lab2Bai3.Models
{
    public class Product
    {
        public string BaiHat { get; set; }
        public string Name { get; set; }
        public List<Product> productList { get; set; }
    }
    
}