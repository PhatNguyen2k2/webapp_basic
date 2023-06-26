package com.hadiemquynh.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hadiemquynh.test.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Random random=new Random();
    int num;

    LinearLayout.LayoutParams params=new LinearLayout.LayoutParams( 200,LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            LinearLayout linearLayout=new LinearLayout(MainActivity.this);
            linearLayout.setLayoutParams(params1);
            params.weight=1.0f;
            params.gravity= Gravity.CENTER;
            for(int i=0;i<3;i++){
                num=random.nextInt(9);
                TextView textView=new TextView(MainActivity.this);
                textView.setText(String.valueOf(num));
                if(num%2==0){
                    textView.setBackgroundColor(Color.GREEN);
                }
                else {
                    textView.setBackgroundColor(Color.GRAY);
                }
                textView.setLayoutParams(params);
                linearLayout.addView(textView);
            }
//
            binding.lvTextView.addView(linearLayout);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.edtNumber.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        addEvents();
    }

    private void addEvents() {
        binding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawUI();
            }
        });
    }

    private void DrawUI() {

        int numb=Integer.parseInt(binding.edtNumber.getText().toString());
        binding.lvTextView.removeAllViews();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<numb;i++){

                    handler.post(runnable);
                    SystemClock.sleep(100);
                }
            }
        });
        thread.start();
    }
}