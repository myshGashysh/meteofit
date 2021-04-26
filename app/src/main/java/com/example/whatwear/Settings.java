package com.example.whatwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    TextView addcity;
    Switch changeTheme;
    int theme;
    ConstraintLayout back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        addcity=findViewById(R.id.addcity);
        changeTheme = findViewById(R.id.changetheme);
        back=findViewById(R.id.backs);
        changeTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    theme=1;
                }else if(isChecked==false)
            {
                    theme=0;
                    }

                    Log.d("checekd",isChecked+"");

            }
        });
        if (theme==0)
        {
            back.setBackgroundColor(Color.parseColor("#ffffff"));
            addcity.setTextColor(Color.parseColor("#FF272727"));
            changeTheme.setTextColor(Color.parseColor("#FF272727"));
        }
        else if(theme==1) {
            back.setBackgroundColor(Color.parseColor("##FF272727"));
            addcity.setTextColor(Color.parseColor("#ffffff"));
            changeTheme.setTextColor(Color.parseColor("#ffffff"));
        }
    }
    public void MainMenu(View v)
    {
        Intent n=new Intent(Settings.this, MainActivity.class);
        String city1 = addcity.getText().toString();
        n.putExtra("CityName",city1);
        n.putExtra("Theme",theme);
        Settings.this.startActivity(n);
    }
}