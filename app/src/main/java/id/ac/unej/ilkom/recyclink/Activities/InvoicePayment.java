package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.R;

public class InvoicePayment extends AppCompatActivity {
    @BindView(R.id.btnConfirmInvoice)
    RelativeLayout btnConfirmInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_payment);
        ButterKnife.bind(this);
        btnConfirmInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InvoicePayment.this, InvoiceCompleted.class);
                startActivity(i);
                finish();
            }
        });
    }
}
