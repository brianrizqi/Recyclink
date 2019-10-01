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
import id.ac.unej.ilkom.recyclink.Models.MitraInvoice;
import id.ac.unej.ilkom.recyclink.R;

public class MitraInvoiceAdapter extends RecyclerView.Adapter<MitraInvoiceAdapter.ViewHolder> {
    private Context context;
    private List<MitraInvoice> list;

    public MitraInvoiceAdapter(Context context, List<MitraInvoice> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_mitra_invoice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MitraInvoice post = list.get(position);
        holder.txtMitraInvoiceItemName.setText(post.getName());
        holder.txtMitraInvoiceItemAddress.setText(post.getAddress());
        holder.txtMitraInvoiceItemDate.setText(post.getDate());
        if (post.getStatus() == 0) {
            holder.txtMitraInvoiceItemStatus.setText("Belum Diproses");
        } else if (post.getStatus() == 1) {
            holder.txtMitraInvoiceItemStatus.setText("Dalam Pengiriman");
        } else {
            holder.txtMitraInvoiceItemStatus.setText("Selesai");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtMitraInvoiceItemName)
        TextView txtMitraInvoiceItemName;
        @BindView(R.id.txtMitraInvoiceItemAddress)
        TextView txtMitraInvoiceItemAddress;
        @BindView(R.id.txtMitraInvoiceItemDate)
        TextView txtMitraInvoiceItemDate;
        @BindView(R.id.txtMitraInvoiceItemStatus)
        TextView txtMitraInvoiceItemStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
