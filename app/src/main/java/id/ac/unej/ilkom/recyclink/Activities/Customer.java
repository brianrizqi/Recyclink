package id.ac.unej.ilkom.recyclink.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Fragments.CategoryFragment;
import id.ac.unej.ilkom.recyclink.Fragments.DashboardFragment;
import id.ac.unej.ilkom.recyclink.Fragments.ShopFragment;
import id.ac.unej.ilkom.recyclink.Fragments.TrashFragment;
import id.ac.unej.ilkom.recyclink.Others.BottomNavigationHelper;
import id.ac.unej.ilkom.recyclink.Fragments.ProfileFragment;
import id.ac.unej.ilkom.recyclink.R;

public class Customer extends AppCompatActivity {
    @BindView(R.id.fragment)
    RelativeLayout fragment;
    Fragment dashboard, category, shop, trash, profile;

    private BottomNavigationView.OnNavigationItemSelectedListener listener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    fragment = dashboard;
                    if (fragment == null) {
                        dashboard = new DashboardFragment();
                    }
                    break;
                case R.id.navigation_kategori:
                    fragment = category;
                    if (fragment == null) {
                        category = new CategoryFragment();
                        fragment = category;
                    }
                    break;
                case R.id.navigation_belanja:
                    fragment = shop;
                    if (fragment == null) {
                        shop = new ShopFragment();
                        fragment = shop;
                    }
                    break;
                case R.id.navigation_sampah:
                    fragment = trash;
                    if (fragment == null) {
                        trash = new TrashFragment();
                        fragment = trash;
                    }
                    break;
                case R.id.navigation_profile:
                    fragment = profile;
                    if (fragment == null) {
                        profile = new ProfileFragment();
                        fragment = profile;
                    }
                    break;
            }
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return fragment != null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ButterKnife.bind(this);
        DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, dashboardFragment);
        fragmentTransaction.commit();


        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        navigationView.setOnNavigationItemSelectedListener(listener);
        BottomNavigationHelper.disableShiftMode(navigationView);
    }
}
