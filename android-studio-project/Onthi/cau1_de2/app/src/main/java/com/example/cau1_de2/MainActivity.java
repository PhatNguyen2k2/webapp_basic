package com.example.cau1_de2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.cau1_de2.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Random random = new Random();
    LinearLayout.LayoutParams paramsedt = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams paramsbtn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

    int ranNumb;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Button btn = new Button(MainActivity.this);
            EditText edt = new EditText(MainActivity.this);
            if(ranNumb %2==0){
                btn.setText(""+ranNumb);
                paramsbtn.gravity = Gravity.CENTER;
                btn.setLayoutParams(paramsbtn);
                binding.containerLayout.addView(btn);
            }else{
                edt.setText(""+ranNumb);
                edt.setLayoutParams(paramsedt);
                binding.containerLayout.addView(edt);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btndraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawUI();
            }
        });
    }

    private void drawUI() {
        binding.edtnumb.setInputType(InputType.TYPE_CLASS_NUMBER);
        int numb = Integer.parseInt(binding.edtnumb.getText().toString());
        binding.containerLayout.removeAllViews();
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=numb;i++){
                    ranNumb =random.nextInt(100);
                    handler.post(runnable);
                    SystemClock.sleep(100);
                }
            }
        });
        backgroundThread.start();
    }
}