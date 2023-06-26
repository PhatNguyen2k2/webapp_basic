<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <formview id="form1" runat="server">
         <div>
         
            <h3>Using the Stock Service</h3>
            
            <br /> <br />
            
            <asp:Label ID="lblmessage" runat="server"></asp:Label>
            
            <br /> <br />
            
            <asp:Button ID="btnpostback" runat="server" Text="Post Back" style="width:132px" />
               
            <asp:Button ID="btnservice" runat="server" onclick="btnservice_Click"  Text="Get Stock" style="width:99px" />
            
         </div>
      </formview>
</asp:Content>
