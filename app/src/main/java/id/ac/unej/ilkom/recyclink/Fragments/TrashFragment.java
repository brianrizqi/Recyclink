package id.ac.unej.ilkom.recyclink.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Activities.TrashPrice;
import id.ac.unej.ilkom.recyclink.Activities.TrashSelling;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Activities.TrashHistory;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrashFragment extends Fragment {
    @BindView(R.id.btnTrashSelling)
    RelativeLayout btnTrashSelling;
    @BindView(R.id.btnTrashPrice)
    RelativeLayout btnTrashPrice;
    @BindView(R.id.btnTrashHistory)
    RelativeLayout btnTrashHistory;

    public TrashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trash, container, false);
        ButterKnife.bind(this, view);
        btnTrashSelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TrashSelling.class);
                getActivity().startActivity(i);
            }
        });
        btnTrashPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TrashPrice.class);
                getActivity().startActivity(i);
            }
        });
        btnTrashHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TrashHistory.class);
                getActivity().startActivity(i);
            }
        });
        return view;
    }

}
