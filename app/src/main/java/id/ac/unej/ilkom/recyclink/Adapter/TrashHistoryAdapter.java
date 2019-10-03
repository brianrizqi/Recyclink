package id.ac.unej.ilkom.recyclink.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.TrashHistory;
import id.ac.unej.ilkom.recyclink.R;

public class TrashHistoryAdapter extends RecyclerView.Adapter<TrashHistoryAdapter.ViewHolder> {
    private Context context;
    private List<TrashHistory> list;

    public TrashHistoryAdapter(Context context, List<TrashHistory> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_trash_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TrashHistory post = list.get(position);
        holder.txtTrashHistoryDate.setText(post.getCreatedAt());
        holder.txtTrashHistoryWeight.setText(post.getQuantity() + " /kg");
        holder.txtTrashHistoryPrice.setText("Rp. " + post.getTotalPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTrashHistoryDate)
        TextView txtTrashHistoryDate;
        @BindView(R.id.txtTrashHistoryWeight)
        TextView txtTrashHistoryWeight;
        @BindView(R.id.txtTrashHistoryPrice)
        TextView txtTrashHistoryPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
