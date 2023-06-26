package com.example.viewp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.viewp2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String [] drinks = {"Tiger", "Heineken", "Sapporo", "Corona Extra", "Sting", "C2", "Olong tea", "Milk tea", "Pepsi", "Coca", "Red-Bull", "Coffee", "Milk", "7up"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        loadData();

    }

    private void loadData() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);
        binding.lvDrinks.setAdapter(adapter);
    }

}