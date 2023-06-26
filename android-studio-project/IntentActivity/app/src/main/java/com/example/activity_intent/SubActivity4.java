package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.activity_intent.databinding.ActivitySub4Binding;

public class SubActivity4 extends AppCompatActivity {

    ActivitySub4Binding binding ;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub4);
        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvents();
    }

    private void addEvents() {
        binding.btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numb = Integer.parseInt(binding.txtNumber.getText().toString());
                int pow_numb = numb * numb;
                intent.putExtra("returned_data",pow_numb);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    private void getData() {
        intent = getIntent();
        binding.txtNumber.setText(intent.getStringExtra("numb"));
    }
}