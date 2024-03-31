package com.example.mdl3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    MaterialAutoCompleteTextView ac;
    EditText lv;

    public String[] stringdataprodi = {"Teknik Informatika", "Sistem Informasi", "Desain Komunikasi Visual", "Manajemen Informatika", "Teknik Sipil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = findViewById(R.id.dataautocomplete);
        lv = findViewById(R.id.datalistview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stringdataprodi);
        ac.setAdapter(adapter);

        ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lv.setText(stringdataprodi[position]);
            }
        });
    }

    public void pilihprodi(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Program Studi di Fakultas Ilmu Komputer");
        builder.setItems(stringdataprodi, (dialog, item) -> {
            lv.setText(stringdataprodi[item]);
            dialog.dismiss();
        }).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getWindow().getDecorView().setBackgroundColor(Color.GRAY);
    }
}
