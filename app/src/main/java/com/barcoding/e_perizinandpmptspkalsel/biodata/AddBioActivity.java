package com.barcoding.e_perizinandpmptspkalsel.biodata;

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

import com.barcoding.e_perizinandpmptspkalsel.Login;
import com.barcoding.e_perizinandpmptspkalsel.MainActivity;
import com.barcoding.e_perizinandpmptspkalsel.R;
import com.barcoding.e_perizinandpmptspkalsel.akun.BiodataActivity;
import com.barcoding.e_perizinandpmptspkalsel.fragment.AkunFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddBioActivity extends AppCompatActivity {

    TextInputEditText textNamaLengkap, textNik, textKwg,
            textAlamat, textProvinsi, textKota, textNoHp, textEmail;
    Button save;
    ProgressBar progressBar;

    Calendar myCalender;
    DatePickerDialog.OnDateSetListener date1;
    TextInputEditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bio);

        textNamaLengkap = findViewById(R.id.namefull);
        textNik = findViewById(R.id.nik);
        date = findViewById(R.id.tanggal_lahir);
        textKwg = findViewById(R.id.kewarganegaraan);
        textAlamat = findViewById(R.id.alamat);
        textProvinsi = findViewById(R.id.provinsi);
        textKota = findViewById(R.id.kota);
        textNoHp = findViewById(R.id.noHandphone);
        textEmail = findViewById(R.id.email);

        save = findViewById(R.id.buttonSave);
        progressBar = findViewById(R.id.progress);

        myCalender = Calendar.getInstance();
        date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, monthOfYear);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.tanggal_lahir);
                String myFormat = "yyyy-MMMM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                tanggal.setText(sdf.format(myCalender.getTime()));
            }
        };

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddBioActivity.this, date1,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        save.setOnClickListener(v -> {

            String nm_lengkap, nik, tgl_lahir, kewarganegaraan, alamat, provinsi, kota, no_hp, email;

            nm_lengkap = String.valueOf(textNamaLengkap.getText());
            nik = String.valueOf(textNik.getText());
            tgl_lahir = String.valueOf(date.getText());
            kewarganegaraan = String.valueOf(textKwg.getText());
            alamat = String.valueOf(textAlamat.getText());
            provinsi = String.valueOf(textProvinsi.getText());
            kota = String.valueOf(textKota.getText());
            no_hp = String.valueOf(textNoHp.getText());
            email = String.valueOf(textEmail.getText());

            if (!nm_lengkap.equals("") && !nik.equals("") && !tgl_lahir.equals("") && !kewarganegaraan.equals("") && !alamat.equals("") && !provinsi.equals("") && !kota.equals("") && !no_hp.equals("") && !email.equals("")) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(() -> {
                    String[] field = new String[9];
                    field[0] = "nm_lengkap";
                    field[1] = "nik";
                    field[2] = "tgl_lahir";
                    field[3] = "kewarganegaraan";
                    field[4] = "alamat";
                    field[5] = "provinsi";
                    field[6] = "kota";
                    field[7] = "no_hp";
                    field[8] = "email";
                    String[] data = new String[9];
                    data[0] = nm_lengkap;
                    data[1] = nik;
                    data[2] = tgl_lahir;
                    data[3] = kewarganegaraan;
                    data[4] = alamat;
                    data[5] = provinsi;
                    data[6] = kota;
                    data[7] = no_hp;
                    data[8] = email;
                    PutData putData = new PutData("http://192.168.43.5/eperizinan/addbiodata.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Save Success")){
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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