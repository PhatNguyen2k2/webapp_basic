package com.hadiemquynh.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hadiemquynh.test.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Random random=new Random();

    int numb1,numb2, temp, row;

    LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams params3=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            row=Integer.parseInt(binding.edtNumber.getText().toString());
            params2.weight=1.0f;
            params2.gravity= Gravity.CENTER;
            params3.weight=2.0f;
            params3.gravity= Gravity.CENTER;
            for(int j=0;j<row;j++){
                    LinearLayout linearLayout=new LinearLayout(MainActivity.this);
                    linearLayout.setLayoutParams(params1);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    TextView textView1=new TextView(MainActivity.this);
                    TextView textView2=new TextView(MainActivity.this);
                    numb1=random.nextInt(9)+1;
                    numb2=random.nextInt(9)+1;
                    if(j%2==0){
                        textView1.setLayoutParams(params2);
                        textView2.setLayoutParams(params3);
                    }
                    else{
                        textView1.setLayoutParams(params3);
                        textView2.setLayoutParams(params2);
                    }
                    textView1.setText(String.valueOf(numb1));
                    textView2.setText(String.valueOf(numb2));
                    if(numb1%2==0){
                        textView1.setBackgroundColor(Color.BLUE);
                    }
                    else {
                        textView1.setBackgroundColor(Color.GRAY);
                    }
                    if(numb2%2==0){
                        textView2.setBackgroundColor(Color.BLUE);
                    }
                    else {
                        textView2.setBackgroundColor(Color.GRAY);
                    }
                    linearLayout.addView(textView1);
                    linearLayout.addView(textView2);
                    binding.lvView.addView(linearLayout);
            }

        }
    };
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
        binding.lvView.removeAllViews();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(runnable);
                SystemClock.sleep(100);
            }
        });
        thread.start();
    }

}