using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Calculator_WebService;

namespace Calculator_WebService
{
    public partial class MathService1 : System.Web.UI.Page
    {
        MathService obj = new MathService();
        int a, b, c;
        string binary;
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnAdd_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            c = obj.Add(a, b);
            lblResult.Text = c.ToString();
        }
        protected void btnSub_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            c = obj.Sub(a, b);
            lblResult.Text = c.ToString();
        }
        protected void BtnMul_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            c = obj.Mul(a, b);
            lblResult.Text = c.ToString();
        }
        protected void btnDiv_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            c = obj.Div(a, b);
            lblResult.Text = c.ToString();
        }
        protected void btnSqrt_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            c =(int)Math.Pow((double)a, (1.0 / b));
            lblResult.Text = c.ToString();
        }
        protected void btnGT_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            c = 1;
            for(int i = 1; i <= a; i++)
            {
                c *= i;
            }
            lblResult.Text = c.ToString();
        }
        protected void btnLT_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            c =(int) Math.Pow((double)a, b);
            lblResult.Text = c.ToString();
        }
        protected void btnD_Click(object sender, EventArgs e)
        {
            a = Convert.ToInt32(txtFno.Text);
            b = Convert.ToInt32(txtSno.Text);
            binary = Convert.ToString(a, b);
            lblResult.Text = binary;
        }
    }
}