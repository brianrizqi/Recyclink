package id.ac.unej.ilkom.recyclink.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Activities.DashboardDetail;
import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;
import id.ac.unej.ilkom.recyclink.R;

public class DashboardPopulerAdapter extends RecyclerView.Adapter<DashboardPopulerAdapter.ViewHolder> {
    private Activity activity;
    private List<DashboardPopuler> list;

    public DashboardPopulerAdapter(Activity activity, List<DashboardPopuler> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.item_dashboard_populer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DashboardPopuler post = list.get(position);
        Glide.with(activity)
                .load(post.getThumbnail())
                .into(holder.itemDashboardImgPopuler);
        holder.itemDashboardTitlePopuler.setText(post.getTitle());
        holder.itemDashboardPricePopuler.setText("Rp. " + post.getPrice());
        if (post.getRating() == null || post.getRating() == "0") {
            holder.itemDashboardRatingPopuler.setText("Rating : -");
        } else {
            holder.itemDashboardRatingPopuler.setText("Rating : " + post.getRating());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, DashboardDetail.class);
                Toast.makeText(activity, post.getThumbnail(), Toast.LENGTH_SHORT).show();
                i.putExtra("data", post);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemDashboardTitlePopuler)
        TextView itemDashboardTitlePopuler;
        @BindView(R.id.itemDashboardPricePopuler)
        TextView itemDashboardPricePopuler;
        @BindView(R.id.itemDashboardRatingPopuler)
        TextView itemDashboardRatingPopuler;
        @BindView(R.id.itemDashboardImgPopuler)
        ImageView itemDashboardImgPopuler;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
