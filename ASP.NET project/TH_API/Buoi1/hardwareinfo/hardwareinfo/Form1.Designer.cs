
namespace hardwareinfo
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.pRam = new System.Diagnostics.PerformanceCounter();
            this.pCpu = new System.Diagnostics.PerformanceCounter();
            this.timer = new System.Windows.Forms.Timer(this.components);
            this.metroLabel1 = new MetroFramework.Controls.MetroLabel();
            this.metroProgressBarCPU = new MetroFramework.Controls.MetroProgressBar();
            this.tblCPU = new MetroFramework.Controls.MetroLabel();
            this.tblRAM = new MetroFramework.Controls.MetroLabel();
            this.metroProgressBarRAM = new MetroFramework.Controls.MetroProgressBar();
            this.metroLabel4 = new MetroFramework.Controls.MetroLabel();
            ((System.ComponentModel.ISupportInitialize)(this.pRam)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pCpu)).BeginInit();
            this.SuspendLayout();
            // 
            // pRam
            // 
            this.pRam.CategoryName = "Memory";
            this.pRam.CounterName = "% Committed Bytes In Use";
            // 
            // pCpu
            // 
            this.pCpu.CategoryName = "Processor";
            this.pCpu.CounterName = "% Processor Time";
            this.pCpu.InstanceName = "_Total";
            // 
            // timer
            // 
            this.timer.Interval = 1000;
            this.timer.Tick += new System.EventHandler(this.timer_Tick);
            // 
            // metroLabel1
            // 
            this.metroLabel1.AutoSize = true;
            this.metroLabel1.FontSize = MetroFramework.MetroLabelSize.Tall;
            this.metroLabel1.Location = new System.Drawing.Point(33, 68);
            this.metroLabel1.Name = "metroLabel1";
            this.metroLabel1.Size = new System.Drawing.Size(50, 25);
            this.metroLabel1.TabIndex = 0;
            this.metroLabel1.Text = "CPU:";
            // 
            // metroProgressBarCPU
            // 
            this.metroProgressBarCPU.Location = new System.Drawing.Point(108, 70);
            this.metroProgressBarCPU.Name = "metroProgressBarCPU";
            this.metroProgressBarCPU.Size = new System.Drawing.Size(540, 23);
            this.metroProgressBarCPU.TabIndex = 1;
            // 
            // tblCPU
            // 
            this.tblCPU.AutoSize = true;
            this.tblCPU.FontSize = MetroFramework.MetroLabelSize.Tall;
            this.tblCPU.Location = new System.Drawing.Point(667, 70);
            this.tblCPU.Name = "tblCPU";
            this.tblCPU.Size = new System.Drawing.Size(37, 25);
            this.tblCPU.TabIndex = 2;
            this.tblCPU.Text = "0%";
            // 
            // tblRAM
            // 
            this.tblRAM.AutoSize = true;
            this.tblRAM.FontSize = MetroFramework.MetroLabelSize.Tall;
            this.tblRAM.Location = new System.Drawing.Point(667, 119);
            this.tblRAM.Name = "tblRAM";
            this.tblRAM.Size = new System.Drawing.Size(37, 25);
            this.tblRAM.TabIndex = 5;
            this.tblRAM.Text = "0%";
            // 
            // metroProgressBarRAM
            // 
            this.metroProgressBarRAM.Location = new System.Drawing.Point(108, 119);
            this.metroProgressBarRAM.Name = "metroProgressBarRAM";
            this.metroProgressBarRAM.Size = new System.Drawing.Size(540, 23);
            this.metroProgressBarRAM.TabIndex = 4;
            // 
            // metroLabel4
            // 
            this.metroLabel4.AutoSize = true;
            this.metroLabel4.FontSize = MetroFramework.MetroLabelSize.Tall;
            this.metroLabel4.Location = new System.Drawing.Point(33, 117);
            this.metroLabel4.Name = "metroLabel4";
            this.metroLabel4.Size = new System.Drawing.Size(55, 25);
            this.metroLabel4.TabIndex = 3;
            this.metroLabel4.Text = "RAM:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.tblRAM);
            this.Controls.Add(this.metroProgressBarRAM);
            this.Controls.Add(this.metroLabel4);
            this.Controls.Add(this.tblCPU);
            this.Controls.Add(this.metroProgressBarCPU);
            this.Controls.Add(this.metroLabel1);
            this.Name = "Form1";
            this.Text = "CPU and RAM";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pRam)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pCpu)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Diagnostics.PerformanceCounter pRam;
        private System.Diagnostics.PerformanceCounter pCpu;
        private System.Windows.Forms.Timer timer;
        private MetroFramework.Controls.MetroLabel metroLabel1;
        private MetroFramework.Controls.MetroProgressBar metroProgressBarCPU;
        private MetroFramework.Controls.MetroLabel tblCPU;
        private MetroFramework.Controls.MetroLabel tblRAM;
        private MetroFramework.Controls.MetroProgressBar metroProgressBarRAM;
        private MetroFramework.Controls.MetroLabel metroLabel4;
    }
}

