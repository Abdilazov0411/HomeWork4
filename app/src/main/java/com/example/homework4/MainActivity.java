package com.example.homework4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private EditText password;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        btn = findViewById(R.id.btn_enter);
        textView1 = findViewById(R.id.description);
        textView2 = findViewById(R.id.clickHere);
        textView3 = findViewById(R.id.forgotPassword);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String login = email.getText().toString().trim();
                String et_password = password.getText().toString().trim();

                if (login.equals("Admin") && et_password.equals("admin")) {
                    email.setVisibility(view.GONE);
                    password.setVisibility(view.GONE);
                    btn.setVisibility(view.GONE);
                    textView1.setVisibility(view.GONE);
                    textView2.setVisibility(view.GONE);
                    textView3.setVisibility(view.GONE);

                    Snackbar.make(findViewById(R.id.mainActivity), "Вы успешно зарегистрировались!!!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(findViewById(R.id.mainActivity), "Неправильный логин и пароль!!!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String login = email.getText().toString().trim();


                if (login.isEmpty()) {
                    btn.setBackgroundColor(Color.parseColor("#9E9E9E"));
                    btn.setEnabled(true);
                } else {
                    btn.setBackgroundColor(Color.parseColor("#FF9800"));
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable){
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String et_password = password.getText().toString().trim();

                if (et_password.isEmpty()) {
                    btn.setBackgroundColor(Color.parseColor("#9E9E9E"));
                    btn.setEnabled(true);
                } else {
                    btn.setBackgroundColor(Color.parseColor("#FF9800"));
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}