using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Calculator_WebService
{
    /// <summary>
    /// Summary description for MathService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class MathService : System.Web.Services.WebService
    {

        public MathService()
        {
            //Uncomment the following line if using designed components  
            //InitializeComponent();  
        }
        [WebMethod]
        public int Add(int x, int y)
        {
            return x + y;
        }
        [WebMethod]
        public int Sub(int x, int y)
        {
            return x - y;
        }
        [WebMethod]
        public int Mul(int x, int y)
        {
            return x * y;
        }
        [WebMethod]
        public int Div(int x, int y)
        {
            return x / y;
        }
        [WebMethod]
        public double Sqrt(int x, int y)
        {
            return Math.Pow((double)x, 1.0/y);
        }
        [WebMethod]
        public int Factorial (int x)
        {
            int c = 1;
            for (int i = 1; i <= x; i++)
            {
                 c *= i;
            }
            return c;
        }
        [WebMethod]
        public double Exponent(int x, int y)
        {
            return Math.Pow((double)x, y);
        }
        [WebMethod]
        public string Coefficient(int x, int y)
        {
            return Convert.ToString(x, y);
        }
    }
}
