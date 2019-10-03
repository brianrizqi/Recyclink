package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductInvoice extends AppCompatActivity {
    public static final String TAG = "ProductInvoice";
    @BindView(R.id.etAddress)
    TextInputEditText etAddress;
    @BindView(R.id.etQuantity)
    TextInputEditText etQuantity;
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
    String courier, payment;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_invoice);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        DashboardPopuler data = (DashboardPopuler) getIntent().getSerializableExtra("data");
        txtProductInvoicePrice.setText("Rp. " + data.getPrice());
        txtProductInvoiceTitle.setText(data.getTitle());
        Glide.with(this)
                .load(data.getThumbnail())
                .into(imgProductInvoice);
        String[] itemCourier = new String[]{"JNE", "JNT", "SiCepat"};
        String[] itemCourierId = new String[]{"jne", "jni", "sicepat"};
        ArrayAdapter<String> adapterCourier = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemCourier);
        spinCourier.setAdapter(adapterCourier);
        spinCourier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                courier = itemCourierId[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        String[] itemPayment = new String[]{"Indomaret", "Alfamart", "BNI"};
        String[] itemPaymentId = new String[]{"indomaret", "alfamart", "bni"};
        ArrayAdapter<String> adapterPayment = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemPayment);
        spinPayment.setAdapter(adapterPayment);
        spinPayment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                payment = itemPaymentId[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onBackPressed();
//                finish();
                Toast.makeText(ProductInvoice.this, tinyDB.getString("token"), Toast.LENGTH_SHORT).show();
            }
        });
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy(data.getId());
            }
        });
    }

    private void buy(int id) {
        String address = etAddress.getText().toString().trim();
        int quantity = Integer.parseInt(etQuantity.getText().toString().trim());
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .order(
                        tinyDB.getString("token"),
                        id,
                        address,
                        quantity,
                        courier,
                        payment
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                Log.d(TAG, "Message :"+response.body().getMessage());
                if (response.body().getSuccess() == 1) {
                    Intent i = new Intent(getApplicationContext(), InvoicePayment.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(ProductInvoice.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
