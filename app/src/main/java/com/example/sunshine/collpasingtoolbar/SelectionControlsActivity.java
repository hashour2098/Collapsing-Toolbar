package com.example.sunshine.collpasingtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SelectionControlsActivity extends AppCompatActivity {

    SwitchCompat switchCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_controls);

        switchCompat = findViewById(R.id.switch_id);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(SelectionControlsActivity.this, isChecked + "", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SelectionControlsActivity.this, isChecked + "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
