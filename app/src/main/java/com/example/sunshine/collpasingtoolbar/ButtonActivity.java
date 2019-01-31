package com.example.sunshine.collpasingtoolbar;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    AppCompatButton raised_btn, flat_btn;
    FloatingActionButton fab_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        raised_btn = findViewById(R.id.raised_btn);
        flat_btn = findViewById(R.id.flat_btn);
        fab_btn = findViewById(R.id.fab_button);
        
        raised_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "Raised Button", Toast.LENGTH_SHORT).show();
            }
        });

        flat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "Flat Button", Toast.LENGTH_SHORT).show();
            }
        });
        
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "Fab Button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
