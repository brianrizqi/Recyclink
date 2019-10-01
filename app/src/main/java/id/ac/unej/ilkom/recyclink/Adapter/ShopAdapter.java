package id.ac.unej.ilkom.recyclink.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Activities.ShopDetail;
import id.ac.unej.ilkom.recyclink.Models.Shop;
import id.ac.unej.ilkom.recyclink.R;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private Activity activity;
    private List<Shop> list;

    public ShopAdapter(Activity activity, List<Shop> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.item_shop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Shop post = list.get(position);
        holder.itemShopDate.setText(post.getCreated_at());
        holder.itemShopTitle.setText(post.getTitle());
        if (post.getStatus().equalsIgnoreCase("0")) {
            holder.itemShopStatus.setText("Menunggu");
        } else if (post.getStatus().equalsIgnoreCase("1")) {
            holder.itemShopStatus.setText("Dalam Proses");
        } else {
            holder.itemShopStatus.setText("Selesai");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, ShopDetail.class);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemShopDate)
        TextView itemShopDate;
        @BindView(R.id.itemShopTitle)
        TextView itemShopTitle;
        @BindView(R.id.itemShopStatus)
        TextView itemShopStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
