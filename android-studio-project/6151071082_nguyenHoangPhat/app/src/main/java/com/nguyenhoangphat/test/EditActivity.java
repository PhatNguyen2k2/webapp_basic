package com.nguyenhoangphat.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nguyenhoangphat.model.Tour;
import com.nguyenhoangphat.test.databinding.ActivityEditBinding;

public class EditActivity extends AppCompatActivity {
    ActivityEditBinding binding;
    Tour p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getData();
        addEvent();
    }

    private void getData() {
        Intent intent = getIntent();
        p = (Tour) intent.getSerializableExtra("tourInfo");
        binding.edtTourName.setText(p.getTourName());
        binding.edtTourDescription.setText(p.getTourDescription());
        binding.edtTourAmount.setText(String.valueOf(p.getTourAmount()));
        binding.edtTourSchedule.setText(p.getTourSchedule());
        binding.edtTourPrice.setText(String.valueOf(p.getTourPrice()));
        binding.edtTourImage.setText(String.valueOf(p.getTourImage()));
    }

    private void addEvent() {
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("TourName", binding.edtTourName.getText().toString());
                values.put("TourDescription", binding.edtTourDescription.getText().toString());
                values.put("TourAmount", Integer.valueOf(binding.edtTourAmount.getText().toString()));
                values.put("TourSchedule", binding.edtTourSchedule.getText().toString());
                values.put("TourPrice", Double.parseDouble(binding.edtTourPrice.getText().toString()));
                values.put("TourImage", Integer.valueOf(binding.edtTourImage.getText().toString()));
                int numbOfRows = MainActivity.db.update(MainActivity.TBL_NAME, values, "TourId=?",
                        new String[]{"1"});
                if(numbOfRows > 0)
                    Toast.makeText(EditActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                finish();
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