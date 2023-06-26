package com.nguyenhoangphat.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nguyenhoangphat.test.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {
    ActivityAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }

    private void addEvent() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Insert data into db
                ContentValues values = new ContentValues();
                values.put("TourName", binding.edtTourName.getText().toString());
                values.put("TourDescription", binding.edtTourDescription.getText().toString());
                values.put("TourAmount", Integer.valueOf(binding.edtTourAmount.getText().toString()));
                values.put("TourSchedule", binding.edtTourSchedule.getText().toString());
                values.put("TourPrice", Double.parseDouble(binding.edtTourPrice.getText().toString()));
                values.put("TourImage", Integer.valueOf(binding.edtTourImage.getText().toString()));
                long numbOfRows = MainActivity.db.insert(MainActivity.TBL_NAME, null, values);
                if(numbOfRows > 0)
                    Toast.makeText(AddActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                finish(); // Close activity
            }
        });
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}