package com.example.admin1.firstapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin1.firstapp.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtA, edtB;
    private TextView txtResult;
    private Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView txtHeading = findViewById(R.id.cal);
        txtHeading.setTextColor(getResources().getColor(R.color.colorAccent));

        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);

        txtResult = findViewById(R.id.txt_result);

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        btnSub = findViewById(R.id.btn_sub);
        btnSub.setOnClickListener(this);
        btnMul = findViewById(R.id.btn_mul);
        btnMul.setOnClickListener(this);
        btnDiv = findViewById(R.id.btn_div);
        btnDiv.setOnClickListener(this);

        /*btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public void onClick(View view) {

        int a,b;
        if(!edtA.getText().toString().trim().isEmpty() && !edtB.getText().toString().trim().isEmpty()){
            a = Integer.parseInt(edtA.getText().toString().trim());
            b = Integer.parseInt(edtB.getText().toString().trim());

            if(view == btnAdd){
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                finish();
                txtResult.setText(""+(a+b));
            }
            else if(view == btnSub){
                txtResult.setText(""+(a-b));

            }
            else if(view == btnMul){
                txtResult.setText(""+(a*b));

            }
            else if(view == btnDiv){
                if(b != 0)
                    txtResult.setText(""+(a/b));
                else {
                    Toast.makeText(this, getString(R.string.can_not_divide_by_0), Toast.LENGTH_SHORT).show();
                    edtB.setText("");
                }
            }
        }
        else {
            Toast.makeText(this, getString(R.string.you_should_specify_numbers), Toast.LENGTH_SHORT).show();
        }
    }
}
