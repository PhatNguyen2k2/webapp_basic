package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView textview1;
    private static final int REQUEST_ENABLE_BT = 1;
    BluetoothAdapter btAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1 = findViewById(R.id.textView1);
        btAdapter =BluetoothAdapter.getDefaultAdapter();
        textview1.append("\nAdapter: "+ btAdapter);

        CheckBluetoothState();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ENABLE_BT){
            CheckBluetoothState();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("MissingPermission")
    private void CheckBluetoothState() {
        if(btAdapter==null){
            textview1.append("\nBluetooth NOT support. Aborting.");
            return;
        }else{
            if(btAdapter.isEnabled()){
                textview1.append("\nBluetooth is enable...");
                textview1.append("\nPaired Devices are: ");
                Set<BluetoothDevice> devices = btAdapter.getBondedDevices();
                for (BluetoothDevice device : devices){
                    textview1.append("\nDevices: "+device.getName()+" , "+device);
                }
            }else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent,REQUEST_ENABLE_BT);
            }
        }
    }
}