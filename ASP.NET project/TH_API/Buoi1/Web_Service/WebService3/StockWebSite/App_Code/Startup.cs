using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(StockWebSite.Startup))]
namespace StockWebSite
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
