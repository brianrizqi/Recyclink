package id.ac.unej.ilkom.recyclink.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.DashboardPopulerAdapter;
import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;
import id.ac.unej.ilkom.recyclink.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    @BindView(R.id.rvDashboardPopuler)
    RecyclerView rvDashboardPopuler;
    List<DashboardPopuler> list = new ArrayList<>();
    DashboardPopulerAdapter adapter;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        populer();
        return view;
    }

    private void populer() {
        rvDashboardPopuler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvDashboardPopuler.setHasFixedSize(true);
        list.add(new DashboardPopuler(1, R.mipmap.logo_green, "Judul", "10.000", "5"));
        list.add(new DashboardPopuler(1, R.mipmap.logo_green, "Judul", "10.000", "5"));
        list.add(new DashboardPopuler(1, R.mipmap.logo_green, "Judul", "10.000", "5"));
        adapter = new DashboardPopulerAdapter(getActivity(), list);
        rvDashboardPopuler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
