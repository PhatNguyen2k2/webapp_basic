package com.hadiemquynh.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hadiemquynh.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawUI();
            }
        });
    }

    private void drawUI() {
        binding.lvTextView.removeAllViews();

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(runnable);
                SystemClock.sleep(100);
            }
        });
        thread.start();
    }

    LinearLayout.LayoutParams params1= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams params2= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run(){


            params2.weight=1.0f;
            String[] ls={"1","2","3","4","5","6","7","8","9","*","0","#"};

            for(int i=0;i<11;i=i+3){
                LinearLayout linearLayout1=new LinearLayout(MainActivity.this);
                linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout1.setLayoutParams(params1);
                Button button1 =new Button(MainActivity.this);
                button1.setLayoutParams(params2);
                Button button2 =new Button(MainActivity.this);
                button2.setLayoutParams(params2);
                Button button3 =new Button(MainActivity.this);
                button3.setLayoutParams(params2);
                button1.setText(ls[i]);
                button2.setText(ls[i+1]);
                button3.setText(ls[i+2]);

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.edtNumber.append(button1.getText().toString());
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.edtNumber.append(button2.getText().toString());
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.edtNumber.append(button3.getText().toString());
                    }
                });


                linearLayout1.addView(button1);

                linearLayout1.addView(button2);

                linearLayout1.addView(button3);

                binding.lvTextView.addView(linearLayout1);



            }


        }
    };
}