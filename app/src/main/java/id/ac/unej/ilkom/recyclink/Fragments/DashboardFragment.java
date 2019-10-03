package id.ac.unej.ilkom.recyclink.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.DashboardPopulerAdapter;
import id.ac.unej.ilkom.recyclink.Adapter.DashboardRekomendAdapter;
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
    private static final String TAG = DashboardFragment.class.getSimpleName();
    @BindView(R.id.rvDashboardRecomend)
    RecyclerView rvDashboardRecomend;
    @BindView(R.id.searchPopuler)
    SearchView searchPopuler;
    @BindView(R.id.rvDashboardPopuler)
    RecyclerView rvDashboardPopuler;
    List<DashboardPopuler> list = new ArrayList<>();
    List<DashboardPopuler> listRekomend = new ArrayList<>();
    DashboardRekomendAdapter adapterRekomend;
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
        rekomded(token);
        searchPopuler.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<DashboardPopuler> dataFilter = new ArrayList<>();
                for (DashboardPopuler data : list) {
                    String title = data.getTitle().toLowerCase();
                    if (title.contains(newText)) {
                        dataFilter.add(data);
                    }
                }
                adapter.setFilter(dataFilter);
                return true;
            }
        });
        return view;
    }

    private void rekomded(String token) {
        rvDashboardRecomend.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvDashboardRecomend.setHasFixedSize(true);
        Call<DashboardPopulerResponse> call = Service
                .getInstance()
                .getAPI()
                .dashboardRekomend(token);
        call.enqueue(new Callback<DashboardPopulerResponse>() {
            @Override
            public void onResponse(Call<DashboardPopulerResponse> call, Response<DashboardPopulerResponse> response) {
                listRekomend = response.body().getData();
                adapterRekomend = new DashboardRekomendAdapter(getActivity(), listRekomend);
                rvDashboardRecomend.setAdapter(adapterRekomend);
                adapterRekomend.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DashboardPopulerResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
