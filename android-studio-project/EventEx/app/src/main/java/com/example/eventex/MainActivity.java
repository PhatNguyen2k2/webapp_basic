package com.example.eventex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.eventex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }
    //onClick XML
    public void showToast(View view) {
//        Log.i(tag:"Test", msg:"Oncick XML");
        Toast.makeText(this, "Onclick XML", Toast.LENGTH_SHORT).show();
    }

    private void addEvent() {
        //Anonymous Listener
        binding.btnAnonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Anonymous", Toast.LENGTH_SHORT).show();
            }
        });
        //Variable Listener
        binding.btnVariableAsListener1.setOnClickListener(onClickListener);
        binding.btnVariableAsListener2.setOnClickListener(onClickListener);
        //Activity Listener
        binding.btnActivityAsListener.setOnClickListener(this);
    }
    //Variable as Listener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btnVariableAsListener1){
                Toast.makeText(MainActivity.this, "variable 1", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "variable 2", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnActivityAsListener){
            Toast.makeText(this, "activity listener", Toast.LENGTH_SHORT).show();
        }
    }
}