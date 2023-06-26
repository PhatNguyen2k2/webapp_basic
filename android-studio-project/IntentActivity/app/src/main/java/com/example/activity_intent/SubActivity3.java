package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.activity_intent.databinding.ActivityMainBinding;
import com.example.activity_intent.databinding.ActivitySub3Binding;
import com.example.models.Product;

public class SubActivity3 extends AppCompatActivity {

    ActivitySub3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sub3);
        binding = ActivitySub3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
    }

    private void getData() {
        // get data from Mainactivity
        Intent intent = getIntent();
//        int numb = intent.getIntExtra("numb",0);
//        float grade = intent.getFloatExtra("grade",0.0f);
//        boolean checked = intent.getBooleanExtra("checked",false);
//        String say = intent.getStringExtra("say");
        //get data Bundle
        Bundle bundle = intent.getBundleExtra("myBundle");
        int numb = bundle.getInt("numb",0);
        float grade = bundle.getFloat("grade",0.0f);
        boolean checked = bundle.getBoolean("checked",false);
        String say = bundle.getString("say");

        Product p = (Product) bundle.getSerializable("product_info");


        //show data
//        binding.txtContent.setText("Numb: "+numb + "\n" +"Grade: "+grade + "\n" +"Checked: "+checked + "\n"+"Say: "+say + "\n");
        binding.txtContent.setText("");
        binding.txtContent.append("Numb:" + numb + "\n");
        binding.txtContent.append("Grade:" + grade + "\n");
        binding.txtContent.append("Checked:" + checked + "\n");
        binding.txtContent.append("Say:" + say + "\n");

        binding.txtContent.append("Product Info: " + p.getProductCode() + " - " + p.getProductName() + " - " + p.getProductPrice() );
    }
}