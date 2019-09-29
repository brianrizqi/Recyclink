package id.ac.unej.ilkom.recyclink.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import id.ac.unej.ilkom.recyclink.Activities.Login;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    @BindView(R.id.btnLogout)
    RelativeLayout btnLogout;
    @BindView(R.id.imgProfile)
    CircleImageView imgProfile;
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
        Glide.with(getActivity())
                .load(R.mipmap.logo_green)
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
