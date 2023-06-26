﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Calculator_WebService.ServiceReference1 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServiceReference1.MathServiceSoap")]
    public interface MathServiceSoap {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Add", ReplyAction="*")]
        int Add(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Add", ReplyAction="*")]
        System.Threading.Tasks.Task<int> AddAsync(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Sub", ReplyAction="*")]
        int Sub(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Sub", ReplyAction="*")]
        System.Threading.Tasks.Task<int> SubAsync(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Mul", ReplyAction="*")]
        int Mul(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Mul", ReplyAction="*")]
        System.Threading.Tasks.Task<int> MulAsync(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Div", ReplyAction="*")]
        int Div(int x, int y);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Div", ReplyAction="*")]
        System.Threading.Tasks.Task<int> DivAsync(int x, int y);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface MathServiceSoapChannel : Calculator_WebService.ServiceReference1.MathServiceSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class MathServiceSoapClient : System.ServiceModel.ClientBase<Calculator_WebService.ServiceReference1.MathServiceSoap>, Calculator_WebService.ServiceReference1.MathServiceSoap {
        
        public MathServiceSoapClient() {
        }
        
        public MathServiceSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public MathServiceSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public MathServiceSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public MathServiceSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public int Add(int x, int y) {
            return base.Channel.Add(x, y);
        }
        
        public System.Threading.Tasks.Task<int> AddAsync(int x, int y) {
            return base.Channel.AddAsync(x, y);
        }
        
        public int Sub(int x, int y) {
            return base.Channel.Sub(x, y);
        }
        
        public System.Threading.Tasks.Task<int> SubAsync(int x, int y) {
            return base.Channel.SubAsync(x, y);
        }
        
        public int Mul(int x, int y) {
            return base.Channel.Mul(x, y);
        }
        
        public System.Threading.Tasks.Task<int> MulAsync(int x, int y) {
            return base.Channel.MulAsync(x, y);
        }
        
        public int Div(int x, int y) {
            return base.Channel.Div(x, y);
        }
        
        public System.Threading.Tasks.Task<int> DivAsync(int x, int y) {
            return base.Channel.DivAsync(x, y);
        }
    }
}
