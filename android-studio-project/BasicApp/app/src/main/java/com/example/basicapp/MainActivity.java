package com.example.basicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
public class MainActivity extends AppCompatActivity {
    CheckBox chkFilm, chkFPT, chkClip;
    Button btnConfirm;
    TextView txtShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        linkViews();
        addEvent();
    }

    private void addEvent() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Bạn chọn: ";
                if(chkFilm.isChecked())
                    res += "Film, ";
                if(chkFPT.isChecked())
                    res += "FPT Play, ";
                if(chkClip.isChecked())
                    res += "Clip TV";
                txtShow.setText(res);
            }
        });
    }

    private void linkViews() {
        chkFilm = findViewById((R.id.chkFilm));
        chkFilm = findViewById((R.id.chkFPT));
        chkFilm = findViewById((R.id.chkClip));

        btnConfirm = findViewById(R.id.btnVote);
        txtShow = findViewById(R.id.txtResult);
    }

}