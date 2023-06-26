using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Weathers
{
    public partial class Form1 : Form
    {
        const string APPID = "10ca9a0f3f9f5524cdc37fa3b3e8769a";
        string cityID = "1566083";
        public Form1()
        {
            InitializeComponent();
            getWeather("1566083");
            getForcast("1566083");
        }

        void getWeather(string city)
        {
            using(WebClient web=new WebClient())
            {
                string url = string.Format("https://api.openweathermap.org/data/2.5/weather?id={0}&appid={1}&units=metric&cnt=6",city,APPID);
                
                var json = web.DownloadString(url);

                var result = JsonConvert.DeserializeObject<WeatherInfo.root>(json);
                WeatherInfo.root outPut = result;

                lbl_textCity.Text = string.Format("{0}", outPut.name);
                lbl_textCity.Text = string.Format("{0}", outPut.sys.country);
                lbl_DoCe.Text = string.Format("{0} \u00B0" + "C", outPut.main.temp);
            }
        }
        void getForcast(string city)
        {
            int day = 2;
            string url = string.Format("https://api.openweathermap.org/data/2.5/forecast/daily?id={0}&cnt={1}&appid={2}&units=metric&cnt=6", city,day, APPID);
            using (WebClient web = new WebClient())
            {
                var json = web.DownloadString(url);
                var Object = JsonConvert.DeserializeObject<WeatherForcast>(json);
                WeatherForcast forcast = Object;

                lbl_Con.Text = string.Format("{0}", forcast.lists[1].weathers[0].main);
                lbl_Des.Text=string.Format("{0}", forcast.lists[1].weathers[0].description);
                lbl_Des.Text = string.Format("{0}", forcast.lists[1].weathers[0].description);
                lblDes2.Text = string.Format("{0} \u00B0" + "C", forcast.lists[1].temp);
                lbl_speed.Text = string.Format("{0} \u00B0" + "C", forcast.lists[1].speed);
            }
        }
    }
}
