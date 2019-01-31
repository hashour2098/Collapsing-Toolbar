package com.example.sunshine.collpasingtoolbar;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.sunshine.collpasingtoolbar.R;

public class TextFieldActivity extends AppCompatActivity {

    AppCompatEditText username_ed;
    AppCompatEditText pass_ed;

    ConstraintLayout activity_text_field_cl;

    TextInputLayout userLayout;
    TextInputLayout passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_field);

        username_ed = findViewById(R.id.username_ed);
        pass_ed = findViewById(R.id.password_ed);

        //method for editText are
        // 1- setOnFocusChangeListener
        // 2- addTextChangedListener

        // to make the focus release from edit text when click to the layout
        activity_text_field_cl = findViewById(R.id.activity_text_field_cl);
        activity_text_field_cl.setOnClickListener(null);

        userLayout = findViewById(R.id.username_layout);

        // required field feature.
        // to make filed required, and set Error if user does not fill it
        username_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(username_ed.getText().toString().isEmpty()) {
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please Enter your username");
                } else {
                    userLayout.setErrorEnabled(false);
                }
            }
        });

        username_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username_ed.getText().toString().isEmpty()) {
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please Enter your username");
                } else {
                    userLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //to make edit text have max number of character entries
        passLayout = findViewById(R.id.password_layout);
        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);


    }
}
