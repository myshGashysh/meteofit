package com.example.whatwear;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
float x1=0,x2=0;
int res;
    TextView tempa;
    Button btnHit;
    TextView txtJson;
    TextView showShoes;
    TextView showTshirt;
    int temperature;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHit = (Button) findViewById(R.id.button);
        txtJson = (TextView) findViewById(R.id.tempa);
        tempa=findViewById(R.id.tempa);
        showShoes=findViewById(R.id.showShoes);
        showTshirt=findViewById(R.id.showTshirt);

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first="https://api.openweathermap.org/data/2.5/weather?q=";

                Bundle argument=getIntent().getExtras();
                Log.d("message",argument.get("CityName").toString());
                String city=argument.get("CityName").toString();
                String second="&appid=50f26afe84d31b6cfe9f02f543179cda";
                String all=first+city+second;
                new JsonTask().execute("all");
            }
        });
    }

    private class JsonTask extends AsyncTask<String, String, String>
    {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()){
                pd.dismiss();
            }
            try {
                JSONObject jsn = new JSONObject(result);
                txtJson.setText(jsn.getString("main"));
                JSONObject jsn1 = new JSONObject(jsn.getString("main"));
                txtJson.setText(jsn1.getString("feels_like"));
                JSONObject jsn2=new JSONObject(jsn.getString("temp"));
                tempa.setText(jsn2+"°");
                temperature=Integer.parseInt((jsn1.getString("feels_like")));
                temperature= (int) (temperature-273.15);
                int temp=temperature;
                if (temp>25)
                {
                    res=5;
                }
                else if(temp<25 && temp>15)
                {
                    res=4;
                }
                else if (temp<15 && temp>2)
                {
                    res=3;
                }
                else if(temp<2 && temp>-10)
                {
                    res=2;
                }
                else if(temp<-10 && temp>-20)
                {
                    res=1;
                }
                else if(temp>-30 && temp<-20)
                {
                    res=0;
                }
                    Shoes res1=new Shoes(res);
            }catch(Exception ex)
            {
            }
        }
        }

        public void ShowClothes()
        {
            Shoes shoes = new Shoes(res);
    for(int i =0 ; i<shoes.result.length; i++)
{
    showShoes.setText(shoes.GetResult()[i]);
}
            Tshirt tshirt=new Tshirt(res);
    for (int i=0; i<tshirt.result.length;i++)
    {
        showTshirt.setText(tshirt.GetResult()[i]);
    }
        }

    public void Settings(View v)
    {
        Intent n1=new Intent(MainActivity.this, Settings.class);
        MainActivity.this.startActivity(n1);
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
                    if(x1>x2)
                    {
                        Intent n=new Intent(MainActivity.this, Clothes.class);
                        MainActivity.this.startActivity(n);
                    }
                   break;
        }
        return false;
    }
}