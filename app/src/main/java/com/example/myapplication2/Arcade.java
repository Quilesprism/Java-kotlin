package com.example.myapplication2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Arcade extends AppCompatActivity {
    Intent intent;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcade);
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("Intent");
        String textopas = nombre;
        TextView out = findViewById(R.id.txtn);
        out.setText(" " + textopas + "Escoge una opcion para listar");
        list = findViewById(R.id.list);
        String[] values = new String[]{"Calculadora", "creditos"};
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int pos = position;
                String itemvalue = (String) list.getItemAtPosition(position);
                switch (pos) {
                    case 0:
                        intent = new Intent(getApplicationContext(), calculadora.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), creditos.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
