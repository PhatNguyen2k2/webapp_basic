package com.example.de4;

import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.de4.databinding.ActivityMainBinding;
import com.example.de4.models.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public static SQLiteDatabase db;
    public static final String DB_NAME = "product_db.db";
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static final String TBL_NAME = "Medicine";

    ArrayAdapter<Product> adapter;
    ArrayList<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        copyDB();
        openDB();
        addEvents();
    }

    private void addEvents() {
        binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                addDialog();
                return false;
            }
        });
    }

    private void addDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_add);
        dialog.setCanceledOnTouchOutside(false);
        Button btnSave = dialog.findViewById(R.id.btnSave);
        EditText productId=(EditText)dialog.findViewById(R.id.edtProductId);
        EditText productName=(EditText)dialog.findViewById(R.id.edtProductName);
        EditText productPrice=(EditText)dialog.findViewById(R.id.edtProductPrice);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("ProductId", productId.getText().toString());
                values.put("ProductName", productName.getText().toString());
                values.put("ProductPrice", Double.parseDouble(productPrice.getText().toString()));
                long numbOfRows = MainActivity.db.insert(MainActivity.TBL_NAME, null, values);
                if(numbOfRows > 0)
                    Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); // Close activity
                loadDataFromDB();
            }
        });
        Button btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void openDB() {
        db = openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);
    }

    private void copyDB() {
        try {
            File dbFile = getDatabasePath(DB_NAME);
            if (!dbFile.exists()) {
                if (processCopy()) {
                    Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
                }

            }
        }catch (Exception e){
            Log.e("Error: ",e.toString());
        }
    }

    private boolean processCopy() {
        String dbPath = getApplicationInfo().dataDir + DB_PATH_SUFFIX + DB_NAME;
        try{
            InputStream inputStream  = getAssets().open(DB_NAME);
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private void loadDataFromDB() {
        products = new ArrayList<Product>();
        Product p;
        Cursor cursor = db.query(TBL_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String pID = cursor.getString(0);
            String pName = cursor.getString(1);
            double pPrice = cursor.getDouble(2);
            p = new Product(pID, pName, pPrice);
            products.add(p);
        }
        cursor.close();

        adapter = new ArrayAdapter<Product>(MainActivity.this, android.R.layout.simple_list_item_1,products);
        binding.lvProduct.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        loadDataFromDB();
        super.onResume();
    }

}