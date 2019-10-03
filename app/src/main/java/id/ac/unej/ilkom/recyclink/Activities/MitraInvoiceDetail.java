package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.MitraInvoice;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MitraInvoiceDetail extends AppCompatActivity {
    @BindView(R.id.imgMitraInvoiceDetail)
    ImageView imgMitraInvoiceDetail;
    @BindView(R.id.txtShopDetailAddress)
    TextView txtShopDetailAddress;
    @BindView(R.id.txtShopDetailStatus)
    TextView txtShopDetailStatus;
    @BindView(R.id.txtShopDetailUser)
    TextView txtShopDetailUser;
    @BindView(R.id.etResi)
    TextInputEditText etResi;
    @BindView(R.id.txtShopDetailTitle)
    TextView txtShopDetailTitle;
    @BindView(R.id.txtShopDetailDate)
    TextView txtShopDetailDate;
    @BindView(R.id.txtShopDetailQuantity)
    TextView txtShopDetailQuantity;
    @BindView(R.id.txtShopDetailPrice)
    TextView txtShopDetailPrice;
    @BindView(R.id.btnConfirm)
    RelativeLayout btnConfirm;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_invoice_detail);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        MitraInvoice data = (MitraInvoice) getIntent().getSerializableExtra("data");
        txtShopDetailUser.setText("Penerima : " + data.getBuyer().getName());
        txtShopDetailAddress.setText("Alamat : " + data.getAlamat());
        if (data.getStatus() == 1) {
            txtShopDetailStatus.setText("Status : Belum diproses");
        } else if (data.getStatus() == 2) {
            txtShopDetailStatus.setText("Status : Dalam pengiriman");
        } else {
            txtShopDetailStatus.setText("Status : Selesai");
        }
        Glide.with(this)
                .load(data.getProductOrders().get(0).getProduct().getThumbnail())
                .into(imgMitraInvoiceDetail);
        txtShopDetailTitle.setText(data.getProductOrders().get(0).getProduct().getTitle());
        txtShopDetailDate.setText(data.getCreatedAt());
        txtShopDetailQuantity.setText("Jumlah : " + data.getProductOrders().get(0).getQuantity());
        txtShopDetailPrice.setText("Rp. " + data.getTotalPrice());
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm(tinyDB.getString("token"), data.getId());
            }
        });
    }

    private void confirm(String token, int id) {
        String resi = etResi.getText().toString().trim();
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .confirmResi(token, id, resi);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MitraInvoiceDetail.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

}
