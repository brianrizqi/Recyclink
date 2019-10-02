package id.ac.unej.ilkom.recyclink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;

public class InvoicePayment extends AppCompatActivity {
    @BindView(R.id.btnBuy)
    RelativeLayout btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_payment);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InvoicePayment.this, InvoiceCompleted.class);
                startActivity(i);
                finish();
            }
        });
    }
}
