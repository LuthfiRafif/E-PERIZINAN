package com.barcoding.e_perizinandpmptspkalsel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Registrasi extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname, textInputEditTextEmail,
            textInputEditTextNamaPengguna, textInputEditTextSandi;
    Button buttonSignUp;
    TextView loginText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        textInputEditTextFullname = findViewById(R.id.namefull);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextNamaPengguna = findViewById(R.id.nama_pengguna);
        textInputEditTextSandi = findViewById(R.id.sandi);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        loginText = findViewById(R.id.loginText);

        progressBar = findViewById(R.id.progress);

        loginText.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        });

        buttonSignUp.setOnClickListener(v -> {

            String nm_lengkap, email, nm_pengguna, kata_sandi;

            nm_lengkap = String.valueOf(textInputEditTextFullname.getText());
            email = String.valueOf(textInputEditTextEmail.getText());
            nm_pengguna = String.valueOf(textInputEditTextNamaPengguna.getText());
            kata_sandi = String.valueOf(textInputEditTextSandi.getText());

            if (!nm_lengkap.equals("") && !email.equals("") && !nm_pengguna.equals("") && !kata_sandi.equals("")) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(() -> {
                    String[] field = new String[4];
                    field[0] = "nm_lengkap";
                    field[1] = "email";
                    field[2] = "nm_pengguna";
                    field[3] = "kata_sandi";
                    String[] data = new String[4];
                    data[0] = nm_lengkap;
                    data[1] = email;
                    data[2] = nm_pengguna;
                    data[3] = kata_sandi;
                    PutData putData = new PutData("http://192.168.43.5/eperizinan/signup.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Sign Up Success")){
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
            else{
                Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
            }
        });
    }
}