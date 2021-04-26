package com.example.whatwear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class Clothes extends AppCompatActivity {
float x1=0,x2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1=event.getX();
                Log.d("down", "true");
                Log.d("down", "true" );
                break;
            case MotionEvent.ACTION_UP:
                x2=event.getX();
                Log.d("up", "true");
                Log.d("up", "true" );
                if(x1<x2)
                {
                    Intent n=new Intent(Clothes.this, MainActivity.class);
                    Clothes.this.startActivity(n);
                }
                break;
        }
        return false;
    }
}