package com.example.admin1.firstapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin1.firstapp.R;


public class FormActivity extends AppCompatActivity {

    private Context mContext;

    private EditText edtFullName, edtAddress;
    private RadioButton radioMale, radioFemale;
    private Spinner spinnerCity;
    private CheckBox chkPlaying, chkReading, chkSwimming, chkDancing;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mContext = this;

        edtFullName = findViewById(R.id.edt_full_name);
        edtAddress = findViewById(R.id.edt_address);
        radioMale = findViewById(R.id.rdb_male);
        radioFemale = findViewById(R.id.rdb_female);
        spinnerCity = findViewById(R.id.spinner_city);
        chkPlaying = findViewById(R.id.check_playing);
        chkReading = findViewById(R.id.check_reading);
        chkSwimming = findViewById(R.id.check_swimming);
        chkDancing = findViewById(R.id.check_dancing);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == btnSubmit){
                    if(!edtFullName.getText().toString().trim().isEmpty()){
                        if(!edtAddress.getText().toString().trim().isEmpty()){
                            if(radioMale.isChecked() || radioFemale.isChecked()){
                                if(!spinnerCity.getSelectedItem().equals(getString(R.string.select_city))){
                                    if(chkPlaying.isChecked() || chkReading.isChecked() || chkSwimming.isChecked() || chkDancing.isChecked()){
                                        Log.d("FormActivity", "spinnerCity : " + spinnerCity.getSelectedItem());
                                    }
                                    else
                                        Toast.makeText(mContext, getString(R.string.select_hobbies), Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(mContext, getString(R.string.select_city), Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(mContext, getString(R.string.select_gender), Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(mContext, getString(R.string.address_should_not_be_empty), Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(mContext, getString(R.string.Full_name_should_not_be_empty), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
