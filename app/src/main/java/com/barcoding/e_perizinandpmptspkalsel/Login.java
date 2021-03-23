package com.barcoding.e_perizinandpmptspkalsel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.barcoding.e_perizinandpmptspkalsel.biodata.AddBioActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEditTextNamaPengguna, textInputEditTextSandi;
    Button buttonLogin;
    TextView SignUp;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextNamaPengguna = findViewById(R.id.username);
        textInputEditTextSandi = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);

        SignUp = findViewById(R.id.signUp);

        progressBar = findViewById(R.id.progress);

        SignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Registrasi.class);
            startActivity(intent);
            finish();
        });

        buttonLogin.setOnClickListener(v -> {

            String nm_pengguna, kata_sandi;

            nm_pengguna = String.valueOf(textInputEditTextNamaPengguna.getText());
            kata_sandi = String.valueOf(textInputEditTextSandi.getText());

            if (!nm_pengguna.equals("") && !kata_sandi.equals("")) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(() -> {
                    String[] field = new String[2];
                    field[0] = "nm_pengguna";
                    field[1] = "kata_sandi";
                    String[] data = new String[2];
                    data[0] = nm_pengguna;
                    data[1] = kata_sandi;
                    PutData putData = new PutData("http://192.168.43.5/eperizinan/login.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Login Success")){
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AddBioActivity.class);
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