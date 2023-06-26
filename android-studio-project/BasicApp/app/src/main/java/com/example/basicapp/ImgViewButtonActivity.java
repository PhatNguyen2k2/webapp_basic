package com.example.basicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.basicapp.databinding.ActivityImgViewButtonBinding;
import com.example.basicapp.databinding.ActivityRadioBinding;

public class ImgViewButtonActivity extends AppCompatActivity {
    ActivityImgViewButtonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_img_view_button);
        binding = ActivityImgViewButtonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }

    private void addEvent() {
    }
}