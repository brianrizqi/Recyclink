package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.InvoiceCompleted;
import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;
import id.ac.unej.ilkom.recyclink.R;

public class ProductInvoice extends AppCompatActivity {
    @BindView(R.id.txtProductInvoiceTitle)
    TextView txtProductInvoiceTitle;
    @BindView(R.id.txtProductInvoiceCategory)
    TextView txtProductInvoiceCategory;
    @BindView(R.id.txtProductInvoicePrice)
    TextView txtProductInvoicePrice;
    @BindView(R.id.imgProductInvoice)
    ImageView imgProductInvoice;
    @BindView(R.id.spinCourier)
    Spinner spinCourier;
    @BindView(R.id.spinPayment)
    Spinner spinPayment;
    @BindView(R.id.btnCancel)
    RelativeLayout btnCancel;
    @BindView(R.id.btnBuy)
    RelativeLayout btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_invoice);
        ButterKnife.bind(this);
        DashboardPopuler data = (DashboardPopuler) getIntent().getSerializableExtra("data");
        txtProductInvoicePrice.setText("Rp. " + data.getPrice());
        txtProductInvoiceTitle.setText(data.getTitle());
        Glide.with(this)
                .load(data.getThumbnail())
                .into(imgProductInvoice);
        String[] itemCourier = new String[]{"JNE", "JNT", "SiCepat"};
        String[] itemCourierId = new String[]{"1", "2", "3"};
        ArrayAdapter<String> adapterCourier = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemCourier);
        spinCourier.setAdapter(adapterCourier);
        String[] itemPayment = new String[]{"Indomaret", "Alfamart", "BNI"};
        String[] itemPaymentId = new String[]{"1", "2", "3"};
        ArrayAdapter<String> adapterPayment = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemPayment);
        spinPayment.setAdapter(adapterPayment);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy();
            }
        });
    }

    private void buy() {
        Intent i = new Intent(ProductInvoice.this, InvoiceCompleted.class);
        startActivity(i);
        finish();
    }
}
