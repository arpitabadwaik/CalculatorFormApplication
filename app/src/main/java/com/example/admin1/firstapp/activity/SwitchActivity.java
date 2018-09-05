package com.example.admin1.firstapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.admin1.firstapp.R;

public class SwitchActivity extends AppCompatActivity {

    Switch s;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        s = (Switch) findViewById(R.id.simpleSwitch);
        Log.d("SwitchActivity", "switch : " + toString());

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s.isChecked()){
                    Toast.makeText(SwitchActivity.this, "Button clicked" ,Toast.LENGTH_SHORT);
                }
                else
                    Toast.makeText(SwitchActivity.this, "Button not clicked" ,Toast.LENGTH_SHORT);
            }
        });

    }
}
