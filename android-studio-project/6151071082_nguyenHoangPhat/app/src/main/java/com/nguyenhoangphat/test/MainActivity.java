package com.nguyenhoangphat.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.nguyenhoangphat.model.Tour;
import com.nguyenhoangphat.test.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String DB_NAME = "product_db.db";
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static final String TBL_NAME = "Tour";

    public static SQLiteDatabase db;
    ArrayAdapter<Tour> adapter;
    ArrayList<Tour> tours;
    Tour selectedTour = null;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        copyDB();
        openDB();
        addEvents();
        registerForContextMenu(binding.lvTour);
    }

    private void addEvents() {
        binding.lvTour.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTour = adapter.getItem(position);
                return false;
            }
        });
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
        tours = new ArrayList<Tour>();
        Tour p;
        Cursor cursor = db.query(TBL_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            int tID = cursor.getInt(0);
            String tName = cursor.getString(1);
            String tDes = cursor.getString(2);
            int tAmount = cursor.getInt(3);
            String tSchedule = cursor.getString(4);
            double tPrice = cursor.getDouble(5);
            int tImage = cursor.getInt(6);
            p = new Tour(tID, tName, tDes, tAmount, tSchedule, tPrice, tImage);
            tours.add(p);
        }
        cursor.close();

        adapter = new ArrayAdapter<Tour>(MainActivity.this, android.R.layout.simple_list_item_1,tours);
        binding.lvTour.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        loadDataFromDB();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if ( item.getItemId() == R.id.mn_Add){
            //open AddActivity
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mn_Edit){
            //open editActivity
            Intent intent = new Intent(MainActivity.this,EditActivity.class);
            if (selectedTour != null){
                intent.putExtra("tourInfo", selectedTour);
                startActivity(intent);
            }
        }
        if (item.getItemId() == R.id.mn_Delete){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Xác nhận xóa");
            builder.setMessage("Bạn có chắc muốn xóa tour'"+ selectedTour.getTourName() + "'?");
            builder.setIcon(android.R.drawable.ic_delete);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int numbOfRows = db.delete(TBL_NAME,"TourId=?",new String[]{String.valueOf(selectedTour.getTourId())});
                    if(numbOfRows >0) {
                        Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        loadDataFromDB();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();

        }
        return super.onContextItemSelected(item);
    }
}