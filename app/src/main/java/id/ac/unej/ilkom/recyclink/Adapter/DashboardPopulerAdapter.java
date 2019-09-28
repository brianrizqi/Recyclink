package id.ac.unej.ilkom.recyclink.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
                .load(post.getImg())
                .into(holder.itemDashboardImgPopuler);
        holder.itemDashboardTitlePopuler.setText(post.getTitle());
        holder.itemDashboardPricePopuler.setText("Rp. " + post.getPrice());
        holder.itemDashboardRatingPopuler.setText("Rating : " + post.getRating());
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
