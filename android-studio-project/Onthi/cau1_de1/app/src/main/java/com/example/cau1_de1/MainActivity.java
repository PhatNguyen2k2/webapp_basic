package com.example.cau1_de1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cau1_de1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Random random = new Random();

    LinearLayout.LayoutParams paramsleft  = new LinearLayout.LayoutParams(500, ViewGroup.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams paramsright  = new LinearLayout.LayoutParams(500,ViewGroup.LayoutParams.WRAP_CONTENT);

    int randNumb;

    Handler handler = new Handler();
    Runnable foregroundThread = new Runnable() {
        @Override
        public void run() {
            Button btn =new Button(MainActivity.this);
            if (randNumb %2 == 0){
                btn.setText(""+randNumb);
                paramsleft.gravity = Gravity.START;
                btn.setLayoutParams(paramsleft);
            }else{
                btn.setText(""+randNumb);
                paramsright.gravity = Gravity.END;
                btn.setLayoutParams(paramsright);
            }
            binding.containerLayout.addView(btn);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();

    }
    private void addEvent() {
        binding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawUI();
            }
        });
    }

    private void drawUI() {
//        binding.edtNum.setInputType(InputType.TYPE_CLASS_NUMBER);
        int numb = Integer.parseInt(binding.edtNum.getText().toString());
        binding.containerLayout.removeAllViews();
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i <= numb;i++){
                    randNumb = random.nextInt(100);
                    handler.post(foregroundThread);
                    SystemClock.sleep(100);
                }
            }
        });
        backgroundThread.start();

    }
}