package id.ac.unej.ilkom.recyclink.Adapter;

import android.content.Context;
import android.content.Intent;
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
import id.ac.unej.ilkom.recyclink.Activities.DashboardDetail;
import id.ac.unej.ilkom.recyclink.Models.CategoryDetail;
import id.ac.unej.ilkom.recyclink.R;

public class CategoryDetailAdapter extends RecyclerView.Adapter<CategoryDetailAdapter.ViewHolder> {
    private Context context;
    private List<CategoryDetail> list;

    public CategoryDetailAdapter(Context context, List<CategoryDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_dashboard_populer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CategoryDetail post = list.get(position);
        Glide.with(context)
                .load(post.getImg())
                .into(holder.itemDashboardImgPopuler);
        holder.itemDashboardTitlePopuler.setText(post.getTitle());
        holder.itemDashboardPricePopuler.setText("Rp. " + post.getPrice());
        holder.itemDashboardRatingPopuler.setText("Rating : " + post.getRating());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DashboardDetail.class);
                i.putExtra("data", post);
                context.startActivity(i);
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
