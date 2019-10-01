package id.ac.unej.ilkom.recyclink.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.ShopAdapter;
import id.ac.unej.ilkom.recyclink.Models.Shop;
import id.ac.unej.ilkom.recyclink.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    @BindView(R.id.rvShop)
    RecyclerView rvShop;
    ShopAdapter adapter;
    List<Shop> list = new ArrayList<>();

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);
        shop();
        return view;
    }

    private void shop() {
        rvShop.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvShop.setHasFixedSize(true);
        list.add(new Shop(1, "20 Januari 2018", "Judul", "0"));
        list.add(new Shop(1, "20 Januari 2018", "Judul", "1"));
        list.add(new Shop(1, "20 Januari 2018", "Judul", "2"));
        adapter = new ShopAdapter(getActivity(), list);
        rvShop.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
