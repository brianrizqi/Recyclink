package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;
import id.ac.unej.ilkom.recyclink.R;

public class DashboardDetail extends AppCompatActivity {
    @BindView(R.id.imgDashboardDetail)
    ImageView imgDashboardDetail;
    @BindView(R.id.txtDashboardDetailTitle)
    TextView txtDashboardDetailTitle;
    @BindView(R.id.txtDashboardDetailPrice)
    TextView txtDashboardDetailPrice;
    @BindView(R.id.txtDashboardDetailUser)
    TextView txtDashboardDetailUser;
    @BindView(R.id.txtDashboardDetailDesc)
    TextView txtDashboardDetailDesc;
    @BindView(R.id.ratingDashboardDetail)
    RatingBar ratingDashboardDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_detail);
        ButterKnife.bind(this);
        DashboardPopuler data = (DashboardPopuler) getIntent().getSerializableExtra("data");
        Glide.with(this)
                .load(data.getThumbnail())
                .into(imgDashboardDetail);
        txtDashboardDetailTitle.setText(data.getTitle());
        txtDashboardDetailDesc.setText(data.getDescription());
        txtDashboardDetailPrice.setText("Rp. " + data.getPrice());
//        txtDashboardDetailUser.setText(data.getUser().getName());
                txtDashboardDetailUser.setText("");
        ratingDashboardDetail.setRating(Float.valueOf(data.getRating() == null ? 0 : Float.valueOf(data.getRating())));
    }
}
