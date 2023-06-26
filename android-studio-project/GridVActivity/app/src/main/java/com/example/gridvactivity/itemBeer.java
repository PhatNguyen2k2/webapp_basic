package com.example.gridvactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gridvactivity.databinding.ActivityItemBeerBinding;

public class itemBeer extends AppCompatActivity {

    ActivityItemBeerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_item_beer);
        binding = ActivityItemBeerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvent();
    }

    private void addEvent() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemBeer.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        binding.txtNameBeer.setText(intent.getStringExtra("txtNameBeer"));
        binding.imvBeer.setImageResource(intent.getIntExtra("imvBeer", 0));
    }
}