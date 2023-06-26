package com.example.activity_intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.activity_intent.databinding.ActivityMainBinding;
import com.example.models.Product;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
//    public static final int REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.i("MainActivity", "onStart");
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
            if (result.getResultCode()==RESULT_OK && result.getData() != null){
                binding.txtResult.setText(String.valueOf(result.getData().getIntExtra("returned_data",0)));
            }
        });
        addEvent();
    }

    private void addEvent() {
        binding.btnOpenSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                startActivity(intent);
            }
        });
        binding.btnOpenSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
        binding.btnOpenSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open sub 3 and send data
                Intent intent = new Intent(MainActivity.this,SubActivity3.class);
                //Attach data using putextra
//                intent.putExtra("numb",89);
//                intent.putExtra("grade",8.9f);
//                intent.putExtra("checked",true);
//                intent.putExtra("say","Hello");

                //attach data using bundle
                Bundle bundle = new Bundle();
                bundle.putInt("numb",89);
                bundle.putFloat("grade",8.9f);
                bundle.putBoolean("checked",true);
                bundle.putString("say","hi");

                //attach object
                Product p = new Product("P01","Heineken",19000);
                bundle.putSerializable("product_info",p);

                intent.putExtra("myBundle",bundle);




                startActivity(intent);
            }
        });
        binding.btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SubActivity4.class);
                // Attach data
                intent.putExtra("numb",binding.edtNumber.getText().toString());
//                startActivity(intent);
//                startActivityForResult(intent,REQUEST_CODE);
                launcher.launch(intent);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
//            binding.txtResult.setText(String.valueOf(data.getIntExtra("returned_data",0)));
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
//        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
//        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
//        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
//        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onDestroy");
    }
}