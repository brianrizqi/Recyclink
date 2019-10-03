package id.ac.unej.ilkom.recyclink.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.TrashSelling;
import id.ac.unej.ilkom.recyclink.R;

public class TrashSellingAdapter extends RecyclerView.Adapter<TrashSellingAdapter.ViewHolder> {
    private Context context;
    private List<TrashSelling> list;
    private TextView totalBerat;
    private TextView totalHarga;

    public TrashSellingAdapter(Context context, List<TrashSelling> list, TextView totalBerat, TextView totalHarga) {
        this.context = context;
        this.list = list;
        this.totalBerat = totalBerat;
        this.totalHarga = totalHarga;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_trash_selling, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TrashSelling post = list.get(position);
        Glide.with(context)
                .load(post.getThumbnail())
                .into(holder.imgTrashSelling);
        holder.txtTrashSellingTitle.setText(post.getTitle());
        holder.txtTrashSellingCategory.setText(post.getCategory());
        holder.txtTrashSellingWeight.setText(post.getPrice() + " /kg");
        holder.etTrashSelling.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int berat = Integer.parseInt(holder.etTrashSelling.getText().toString());
                int currentBerat = Integer.parseInt(totalBerat.getText().toString());
                int currentTotal = Integer.parseInt(totalHarga.getText().toString());
                totalBerat.setText((currentBerat + berat) + "");
                totalHarga.setText((currentTotal + (post.getPrice() * berat)) + "");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgTrashSelling)
        ImageView imgTrashSelling;
        @BindView(R.id.txtTrashSellingTitle)
        TextView txtTrashSellingTitle;
        @BindView(R.id.txtTrashSellingCategory)
        TextView txtTrashSellingCategory;
        @BindView(R.id.txtTrashSellingWeight)
        TextView txtTrashSellingWeight;
        @BindView(R.id.etTrashSelling)
        EditText etTrashSelling;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
