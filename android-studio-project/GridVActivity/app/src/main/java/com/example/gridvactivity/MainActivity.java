package com.example.gridvactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.adapter.BeerAdapter;
import com.example.gridvactivity.databinding.ActivityMainBinding;
import com.example.models.Beer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BeerAdapter adapter;
    ArrayList<Beer> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_beer);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initAdapter();
        addEvent();
    }



    private void addEvent() {
        binding.grvBeers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Beer selectedBeer = (Beer) adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this,itemBeer.class);
                intent.putExtra("imvBeer",selectedBeer.getBeerThumb());
                intent.putExtra("txtNameBeer",selectedBeer.getBeerName());
                startActivity(intent);
//                Toast.makeText(MainActivity.this, selectedBeer.getBeerName().toString() + "\n"+selectedBeer.getBeerThumb(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initAdapter() {
        initData();
        adapter = new BeerAdapter(MainActivity.this,R.layout.item_list,beers);
        binding.grvBeers.setAdapter(adapter);
    }

    private void initData() {
        beers = new ArrayList<>();
        beers.add(new Beer(R.drawable.heineken,"Heineken"));
        beers.add(new Beer(R.drawable.tiger,"Tiger"));
        beers.add(new Beer(R.drawable.beer333,"Beer 333"));
        beers.add(new Beer(R.drawable.saigon,"Sài Gòn"));
        beers.add(new Beer(R.drawable.hanoi,"Hà Nội"));
        beers.add(new Beer(R.drawable.larue,"Larue"));
        beers.add(new Beer(R.drawable.sapporo,"Sapporo"));
    }
}