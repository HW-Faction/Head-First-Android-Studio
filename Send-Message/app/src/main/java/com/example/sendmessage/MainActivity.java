package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Locale myLocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeLanguage = findViewById(R.id.es);
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("es");
            }
        });
    }

    public void send_message(View view) {
        EditText message = findViewById(R.id.message);

        // to go to the second activity
        /* Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(Main2Activity.MESSAGE, "" + message.getText().toString());
        startActivity(intent); */

        // to go to different app and send the message
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "" + message.getText().toString());
        startActivity(intent);
    }


    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();

        DisplayMetrics dm = res.getDisplayMetrics();

        Configuration conf = res.getConfiguration();

        conf.locale = myLocale;

        res.updateConfiguration(conf, dm);

        Intent refresh = new Intent(this, MainActivity.class);

        startActivity(refresh);

    }

}
