package id.ac.unej.ilkom.recyclink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import id.ac.unej.ilkom.recyclink.Activities.Customer;
import id.ac.unej.ilkom.recyclink.Activities.MainActivity;

public class InvoiceCompleted extends AppCompatActivity {
    private static int splashInterval = 3000;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_completed);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(InvoiceCompleted.this, Customer.class);
                startActivity(i);
                finish();
            }
        }, splashInterval);
    }
}
