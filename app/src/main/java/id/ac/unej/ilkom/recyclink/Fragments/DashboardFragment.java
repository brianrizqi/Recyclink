package id.ac.unej.ilkom.recyclink.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.DashboardPopulerAdapter;
import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.DashboardPopulerResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    @BindView(R.id.rvDashboardPopuler)
    RecyclerView rvDashboardPopuler;
    List<DashboardPopuler> list = new ArrayList<>();
    DashboardPopulerAdapter adapter;
    TinyDB tinyDB;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        tinyDB = new TinyDB(getActivity());
        String token = tinyDB.getString("token");
        populer(token);
        return view;
    }

    private void populer(String token) {
        rvDashboardPopuler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvDashboardPopuler.setHasFixedSize(true);
        Call<DashboardPopulerResponse> call = Service
                .getInstance()
                .getAPI()
                .dashboardPopuler(token);
        call.enqueue(new Callback<DashboardPopulerResponse>() {
            @Override
            public void onResponse(Call<DashboardPopulerResponse> call, Response<DashboardPopulerResponse> response) {
                list = response.body().getData();
                adapter = new DashboardPopulerAdapter(getActivity(), list);
                rvDashboardPopuler.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DashboardPopulerResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
