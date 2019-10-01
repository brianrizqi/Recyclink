package id.ac.unej.ilkom.recyclink.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.MitraProduct;
import id.ac.unej.ilkom.recyclink.R;

public class MitraProductAdapter extends RecyclerView.Adapter<MitraProductAdapter.ViewHolder> {
    private Context context;
    private List<MitraProduct> list;

    public MitraProductAdapter(Context context, List<MitraProduct> list) {
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
