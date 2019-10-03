package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.GetUserResponse;
import id.ac.unej.ilkom.recyclink.Models.User;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Setting extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = Setting.class.getSimpleName();
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.btn_change)
    RelativeLayout btnChange;
    @BindView(R.id.btn_cancel)
    RelativeLayout btnCancel;
    private User user;
    private TinyDB tinyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        tinyDB = new TinyDB(this);

        Call<GetUserResponse> call = Service
                .getInstance()
                .getAPI()
                .getUser(tinyDB.getString("token"));
        call.enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                User user = response.body().getUser();
                edtName.setText(user.getName());
                edtEmail.setText(user.getEmail());
                edtUsername.setText(user.getUsername());
            }

            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) {

            }
        });

        btnChange.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_change) {
            Call<DefaultResponse> call = Service
                    .getInstance()
                    .getAPI()
                    .updateProfile(
                            tinyDB.getString("token"),
                            edtName.getText().toString(),
                            edtUsername.getText().toString(),
                            edtEmail.getText().toString()
                    );
            call.enqueue(new Callback<DefaultResponse>() {
                @Override
                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                    Toast.makeText(Setting.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    finish();
                }

                @Override
                public void onFailure(Call<DefaultResponse> call, Throwable t) {

                }
            });
        } else if (view.getId() == R.id.btn_cancel) {
            onBackPressed();
            finish();
        }
    }
}
