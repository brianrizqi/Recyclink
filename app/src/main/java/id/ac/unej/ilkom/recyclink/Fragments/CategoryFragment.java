package id.ac.unej.ilkom.recyclink.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Activities.CategoryDetail;
import id.ac.unej.ilkom.recyclink.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    @BindView(R.id.btnCategoryShirt)
    LinearLayout btnCategoryShirt;
    @BindView(R.id.btnCategoryDecoration)
    LinearLayout btnCategoryDecoration;
    @BindView(R.id.btnCategoryBag)
    LinearLayout btnCategoryBag;
    @BindView(R.id.btnCategoryFurniture)
    LinearLayout btnCategoryFurniture;
    @BindView(R.id.btnCategoryAccessories)
    LinearLayout btnCategoryAccessories;
    @BindView(R.id.btnCategoryOthers)
    LinearLayout btnCategoryOthers;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        btnCategoryShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CategoryDetail.class);
                i.putExtra("category", "shirt");
                getActivity().startActivity(i);
            }
        });
        btnCategoryDecoration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CategoryDetail.class);
                i.putExtra("category", "decoration");
                getActivity().startActivity(i);
            }
        });
        btnCategoryBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CategoryDetail.class);
                i.putExtra("category", "bag");
                getActivity().startActivity(i);
            }
        });
        btnCategoryFurniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CategoryDetail.class);
                i.putExtra("category", "furniture");
                getActivity().startActivity(i);
            }
        });
        btnCategoryAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CategoryDetail.class);
                i.putExtra("category", "accessories");
                getActivity().startActivity(i);
            }
        });
        btnCategoryOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CategoryDetail.class);
                i.putExtra("category", "other");
                getActivity().startActivity(i);
            }
        });
        return view;
    }

}
