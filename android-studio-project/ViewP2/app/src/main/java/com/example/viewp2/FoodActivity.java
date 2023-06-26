package com.example.viewp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.viewp2.databinding.ActivityFoodBinding;

public class FoodActivity extends AppCompatActivity {
    ActivityFoodBinding binding;
    String[] foods;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_food);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        foods = getResources().getStringArray(R.array.foodList);
        adapter = new ArrayAdapter<String>(FoodActivity.this, android.R.layout.simple_list_item_1, foods);
        binding.lvFoods.setAdapter(adapter);
    }
}