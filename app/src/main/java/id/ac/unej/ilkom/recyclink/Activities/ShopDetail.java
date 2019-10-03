package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import id.ac.unej.ilkom.recyclink.Models.Shop;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopDetail extends AppCompatActivity {
    @BindView(R.id.imgShopDetail)
    ImageView imgShopDetail;
    @BindView(R.id.txtShopDetailAddress)
    TextView txtShopDetailAddress;
    @BindView(R.id.txtShopDetailStatus)
    TextView txtShopDetailStatus;
    @BindView(R.id.txtShopDetailUser)
    TextView txtShopDetailUser;
    @BindView(R.id.txtShopDetailTitle)
    TextView txtShopDetailTitle;
    @BindView(R.id.txtShopDetailDate)
    TextView txtShopDetailDate;
    @BindView(R.id.txtShopDetailQuantity)
    TextView txtShopDetailQuantity;
    @BindView(R.id.txtShopDetailPrice)
    TextView txtShopDetailPrice;
    @BindView(R.id.txtShopDetailCourier)
    TextView txtShopDetailCourier;
    @BindView(R.id.txtShopDetailResi)
    TextView txtShopDetailResi;
    @BindView(R.id.card)
    CardView card;
    @BindView(R.id.btnConfirm)
    RelativeLayout btnConfirm;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        Shop data = (Shop) getIntent().getSerializableExtra("data");
        txtShopDetailTitle.setText(data.getProductOrders().get(0).getProduct().getTitle());
        Glide.with(this)
                .load(data.getProductOrders().get(0).getProduct().getThumbnail())
                .into(imgShopDetail);
        txtShopDetailDate.setText(data.getCreatedAt());
        txtShopDetailQuantity.setText("Jumlah : " + data.getProductOrders().get(0).getQuantity());
        txtShopDetailPrice.setText("Rp. " + data.getTotalPrice());
        txtShopDetailUser.setText("Pengirim : " + data.getProductOrders().get(0).getProduct().getUser().getName());
        txtShopDetailAddress.setText(data.getAlamat());
        txtShopDetailCourier.setText("Jenis Kurir : " + data.getCourier());
        if (data.getStatus() == 1) {
            txtShopDetailStatus.setText("Status : Belum diproses");
        } else if (data.getStatus() == 2) {
            txtShopDetailStatus.setText("Status : Dalam pengiriman");
        } else {
            card.setVisibility(View.GONE);
            txtShopDetailStatus.setText("Status : Selesai");
        }
        if (data.getResi() == null) {
            txtShopDetailResi.setText("No Resi : -");
        } else {
            txtShopDetailResi.setText("No Resi : " + data.getResi());
        }
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm(tinyDB.getString("token"), data.getId());
            }
        });
    }

    private void confirm(String token, int id) {
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .confirmBuyer(token, id);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ShopDetail.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
