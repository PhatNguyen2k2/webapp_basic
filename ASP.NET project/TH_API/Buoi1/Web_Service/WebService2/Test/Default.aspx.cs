using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btnShow_Click(object sender, EventArgs e)
    {
        localhost.WebServiceSoapClient mys = new localhost.WebServiceSoapClient();
        int a = Convert.ToInt32(txtFirst.Text);
        int b = Convert.ToInt32(txtSecond.Text);
        int c = mys.Multiplication(a, b);
        txtResult.Text = c.ToString();
    }
}