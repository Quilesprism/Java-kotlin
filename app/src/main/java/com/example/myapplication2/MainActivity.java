package com.example.myapplication2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton btniniciar;
    ActivityResultLauncher<Intent> activityLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {

                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText sapaperra;
        sapaperra=findViewById(R.id.edtnombr);
        btniniciar= findViewById(R.id.btniniciar);
        btniniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( MainActivity.this, Arcade.class);
                intent.putExtra("Intent", sapaperra.getText().toString());
                activityLauncher.launch(intent);
            }
        } );




    }

}