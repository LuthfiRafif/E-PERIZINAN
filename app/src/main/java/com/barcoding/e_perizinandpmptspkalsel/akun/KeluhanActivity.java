package com.barcoding.e_perizinandpmptspkalsel.akun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.barcoding.e_perizinandpmptspkalsel.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class KeluhanActivity extends AppCompatActivity {

    ListView lv;

    FloatingActionButton btnAction;

    private Dialog customDialog;
    private EditText tv_nama;
    private EditText tv_email;
    private EditText tv_keluhan;
    private Button btnKirim;



    String[] Keluhan = {"Saya sudah melakukan registrasi kenapa enda bisa login?",
            "Kenapa data saya tidak pernah ada kelanjutannya?",
            "Loadingnya sangat lama ketika mengajukan perizinan",
            "Kadang-kadang gagal login padahal nama pengguna dan kata sandinya sudah benar"
    };

    String[] Tanggal = {"Sudah direspon", "Sudah direspon", "Belum direspon",
            "Sudah direspon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);

        setTitle("Keluhan");

        initViews();

        btnAction = findViewById(R.id.btnAction);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });

        lv = findViewById(R.id.lv_list);
        ListAdapterKeluhan listAdapterKeluhan = new ListAdapterKeluhan(this, Keluhan, Tanggal);
        lv.setAdapter(listAdapterKeluhan);
    }

    private void initViews(){
        initCustomDialog();
    }

    private void initCustomDialog() {
        customDialog = new Dialog(KeluhanActivity.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.costum_dialog_keluhan);
        customDialog.setCancelable(true);

        tv_nama = customDialog.findViewById(R.id.tv_nm_pengirim);
        tv_email = customDialog.findViewById(R.id.tv_email);
        tv_keluhan = customDialog.findViewById(R.id.tv_keluhan);
        btnKirim = customDialog.findViewById(R.id.btnKirim);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nm_lengkap, email, keluhan;

                nm_lengkap = String.valueOf(tv_nama.getText());
                email = String.valueOf(tv_email.getText());
                keluhan = String.valueOf(tv_keluhan.getText());

                if (!nm_lengkap.equals("") && !email.equals("") && !keluhan.equals("")) {
                    Handler handler = new Handler();
                    handler.post(() -> {
                        String[] field = new String[3];
                        field[0] = "nm_lengkap";
                        field[1] = "email";
                        field[2] = "keluhan";
                        String[] data = new String[5];
                        data[0] = nm_lengkap;
                        data[1] = email;
                        data[2] = keluhan;
                        PutData putData = new PutData("http://192.168.43.5/eperizinan/keluhan.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Send Success")){
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), SaranActivity.class);
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

            }
        });
    }
}