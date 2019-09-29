package id.ac.unej.ilkom.recyclink.Adapter;

import android.content.Context;
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
import id.ac.unej.ilkom.recyclink.Models.Trash;
import id.ac.unej.ilkom.recyclink.R;

public class TrashPriceAdapter extends RecyclerView.Adapter<TrashPriceAdapter.ViewHolder> {
    private Context context;
    private List<Trash> list;

    public TrashPriceAdapter(Context context, List<Trash> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_trash_price, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Trash post = list.get(position);
        Glide.with(context)
                .load(post.getImg())
                .into(holder.imgTrashPrice);
        holder.txtTrashPriceTitle.setText(post.getName());
        holder.txtTrashPriceCategory.setText(post.getCategory());
        holder.txtTrashPriceTotal.setText(post.getPrice() + " /kg");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgTrashPrice)
        ImageView imgTrashPrice;
        @BindView(R.id.txtTrashPriceTitle)
        TextView txtTrashPriceTitle;
        @BindView(R.id.txtTrashPriceCategory)
        TextView txtTrashPriceCategory;
        @BindView(R.id.txtTrashPriceTotal)
        TextView txtTrashPriceTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
