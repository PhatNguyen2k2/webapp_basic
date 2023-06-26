package com.example.viewp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.models.Product;
import com.example.viewp2.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {
    ActivityProductBinding binding;
    ArrayAdapter<Product> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_product);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
        addEvent();
    }

    private void initAdapter() {
        adapter = new ArrayAdapter<Product>(ProductActivity.this, android.R.layout.simple_list_item_1);
        binding.lvProduct.setAdapter(adapter);
    }

    private void addEvent() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.edtName.getText().toString();
                double price = Double.parseDouble(binding.edtPrice.getText().toString());
                Product p = new Product(name, price);
                adapter.add(p);
            }
        });
        binding.lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product selectedProduct = adapter.getItem(i);
                Toast.makeText(ProductActivity.this, selectedProduct.getProductName() + " - "
                        + selectedProduct.getProductPrice(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = adapter.getItem(i);
                adapter.remove(p);
                return true;
            }
        });
    }
}