package com.example.usingmessageexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.usingmessageexample.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Random random = new Random();
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.WRAP_CONTENT);
    //Method 1: using sendMessage
//    Handler handler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(@NonNull Message message) {
//            //update UI
//            int randNumb = (int) message.obj;
//            ImageView imv = new ImageView(MainActivity.this);
//            if(randNumb % 2 == 0)
//                imv.setImageResource(R.drawable.ic_android_black_24dp);
//            else
//                imv.setImageResource(R.drawable.baseline_30fps_24);
//
//            imv.setLayoutParams(params);
//
//            binding.containerLayout.addView(imv);
//            binding.txtPercent.setText(message.arg1 + " %");
//            if(message.arg1 == 100)
//                binding.txtPercent.setText("DONE!");
//            binding.pbPercent.setProgress(message.arg1);
//            return true;
//        }
//    });
    //Method 2: using Post
    int percent, randNumb;
    Handler handler = new Handler();
    Runnable foregroundThread = new Runnable() {
        @Override
        public void run() {
            //Update UI
            ImageView imv = new ImageView(MainActivity.this);
            if(randNumb % 2 == 0)
                imv.setImageResource(R.drawable.ic_android_black_24dp);
            else
                imv.setImageResource(R.drawable.baseline_30fps_24);

            imv.setLayoutParams(params);

            binding.containerLayout.addView(imv);
            binding.txtPercent.setText(percent + " %");
            if(percent == 100)
                binding.txtPercent.setText("DONE!");
            binding.pbPercent.setProgress(percent);
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
            public void onClick(View view) {
                drawUI();
            }
        });
    }

    private void drawUI() {
    //Method 1: using sendMessage
//        //BackgroundThread
//        int numb = Integer.parseInt(binding.edtNumbOfViews.getText().toString());
//        binding.containerLayout.removeAllViews();
//        Thread backgroundThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 1; i <= numb; i++){
//                    Message message = handler.obtainMessage();
//                    message.arg1 = i * 100 / numb; // percent
//                    message.obj = random.nextInt(100);
//                    handler.sendMessage(message);
//                    SystemClock.sleep(100);
//                }
//            }
//        });
//        backgroundThread.start();
    //Method 2: using Post
    int numb = Integer.parseInt(binding.edtNumbOfViews.getText().toString());
    binding.containerLayout.removeAllViews();
    Thread backgroundThread = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 1; i <= numb; i++){
                percent = i * 100 / numb; // percent
                randNumb = random.nextInt(100);
                handler.post(foregroundThread);
                SystemClock.sleep(100);
            }
        }
    });
    backgroundThread.start();
    }
}