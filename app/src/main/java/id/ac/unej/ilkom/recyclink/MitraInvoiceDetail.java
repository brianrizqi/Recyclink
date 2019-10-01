package id.ac.unej.ilkom.recyclink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MitraInvoiceDetail extends AppCompatActivity {
    @BindView(R.id.imgMitraInvoiceDetail)
    ImageView imgMitraInvoiceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_invoice_detail);
        ButterKnife.bind(this);
        Glide.with(this)
                .load("https://www.craftline.co.id/bima-content//l-ppc483f6ce851c9ecd9fb835ff7551737c20180209085746.jpg")
                .into(imgMitraInvoiceDetail);
    }
}
