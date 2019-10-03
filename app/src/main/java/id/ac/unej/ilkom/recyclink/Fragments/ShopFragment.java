package id.ac.unej.ilkom.recyclink.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.ShopAdapter;
import id.ac.unej.ilkom.recyclink.Models.Shop;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.ShopResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    @BindView(R.id.rvShop)
    RecyclerView rvShop;
    ShopAdapter adapter;
    TinyDB tinyDB;
    List<Shop> list = new ArrayList<>();

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);
        tinyDB = new TinyDB(getActivity());
        shop(tinyDB.getString("token"));
        return view;
    }

    private void shop(String token) {
        rvShop.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvShop.setHasFixedSize(true);
        Call<ShopResponse> call = Service
                .getInstance()
                .getAPI()
                .myOrder(
                        token
                );
        call.enqueue(new Callback<ShopResponse>() {
            @Override
            public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                list = response.body().getData();
                adapter = new ShopAdapter(getActivity(), list);
                rvShop.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ShopResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
