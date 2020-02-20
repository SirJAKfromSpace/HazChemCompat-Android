package com.example.hazchemcompat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class StartLang extends AppCompatActivity {

    SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPrefs = getSharedPreferences("com.sks.amago.userprefs", MODE_PRIVATE);
        Locale locale = new Locale(sharedPrefs.getString("lastselectedlang", "en"));
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_lang);
    }

    public void PickBangla(View view) {
        Locale locale = new Locale("bn");
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        startActivity(new Intent(this, MainActivity.class));

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("lastselectedlang", "bn");
        editor.apply();
    }

    public void PickEnglish(View view) {
        Locale locale = new Locale("en");
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        startActivity(new Intent(this, MainActivity.class));

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("lastselectedlang", "en");
        editor.apply();
    }
}
