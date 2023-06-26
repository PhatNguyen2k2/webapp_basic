package com.example.basicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.basicapp.databinding.ActivityRadioBinding;

public class RadioActivity extends AppCompatActivity {
    ActivityRadioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_radio);
        binding = ActivityRadioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnBinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "";
                int checkedRadioButtonId = binding.radgBinhChon.getCheckedRadioButtonId();
                if(checkedRadioButtonId > 0){
                    RadioButton radio = findViewById(checkedRadioButtonId);
                    res += radio.getText().toString();
                }
                binding.txtResult.setText(res);
            }
        });
    }
}