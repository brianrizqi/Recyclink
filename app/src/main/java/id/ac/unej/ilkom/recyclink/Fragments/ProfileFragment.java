package id.ac.unej.ilkom.recyclink.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import id.ac.unej.ilkom.recyclink.Activities.Login;
import id.ac.unej.ilkom.recyclink.Activities.MitraCreateProduct;
import id.ac.unej.ilkom.recyclink.Activities.MitraInvoices;
import id.ac.unej.ilkom.recyclink.Activities.MitraProducts;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    @BindView(R.id.txtProfileName)
    TextView txtProfileName;
    @BindView(R.id.txtProfileEmail)
    TextView txtProfileEmail;
    @BindView(R.id.txtProfileRole)
    TextView txtProfileRole;
    @BindView(R.id.txtProfileItemName)
    TextView txtProfileItemName;
    @BindView(R.id.txtProfileItemRole)
    TextView txtProfileItemRole;
    @BindView(R.id.layoutProfileMitra)
    LinearLayout layoutProfileMitra;
    @BindView(R.id.btnLogout)
    RelativeLayout btnLogout;
    @BindView(R.id.imgProfile)
    CircleImageView imgProfile;
    @BindView(R.id.btnMitraProduct)
    RelativeLayout btnMitraProduct;
    @BindView(R.id.btnInvoices)
    RelativeLayout btnInvoices;
    TinyDB tinyDB;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        tinyDB = new TinyDB(getActivity());
        txtProfileName.setText(tinyDB.getString("name"));
        txtProfileEmail.setText(tinyDB.getString("email"));
        txtProfileItemName.setText(tinyDB.getString("username"));
        if (tinyDB.getInt("role") == 2) {
            layoutProfileMitra.setVisibility(View.VISIBLE);
            txtProfileRole.setText("Mitra");
            txtProfileItemRole.setText("Mitra");
        } else {
            layoutProfileMitra.setVisibility(View.GONE);
            txtProfileRole.setText("Customer");
            txtProfileItemRole.setText("Customer");
        }
        btnMitraProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MitraProducts.class);
                startActivity(i);
            }
        });
        btnInvoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MitraInvoices.class);
                startActivity(i);
            }
        });
        Glide.with(getActivity())
                .load(R.mipmap.student)
                .into(imgProfile);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        return view;
    }

    private void logout() {
        Intent i = new Intent(getActivity(), Login.class);
        startActivity(i);
        tinyDB.clear();
        getActivity().finish();
    }

}
