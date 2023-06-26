package com.example.viewp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.adapters.BeerAdapter;
import com.example.models.Beer;
import com.example.viewp2.databinding.ActivityBeerBinding;

import java.util.ArrayList;

public class BeerActivity extends AppCompatActivity {
    ActivityBeerBinding binding;
    BeerAdapter adapter;
    ArrayList<Beer> beers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_beer);
        binding = ActivityBeerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
    }

    private void initAdapter() {
        initData();
        adapter = new BeerAdapter(BeerActivity.this, R.layout.item_list, beers);
        binding.lvBeers.setAdapter(adapter);
    }

    private void initData() {
        beers = new ArrayList<>();
        beers.add(new Beer(R.drawable.heineken, "Heineken", 190000));
        beers.add(new Beer(R.drawable.tiger, "Tiger", 190000));
        beers.add(new Beer(R.drawable.beer333, "Beer333", 190000));
        beers.add(new Beer(R.drawable.saigon, "SaiGon", 190000));
        beers.add(new Beer(R.drawable.larue, "Larue", 190000));
        beers.add(new Beer(R.drawable.sapporo, "Sapporo", 190000));
    }
}