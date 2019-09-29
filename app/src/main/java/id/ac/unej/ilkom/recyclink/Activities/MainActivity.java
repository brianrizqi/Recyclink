package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;

public class MainActivity extends AppCompatActivity {
    private static int splashInterval = 3000;
    private Thread thread;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tinyDB = new TinyDB(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                finish();
            }
        }, splashInterval);
    }
}
