package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Models.Category;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.CategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MitraCreateProduct extends AppCompatActivity {

    private static final String TAG = MitraCreateProduct.class.getSimpleName();
    @BindView(R.id.imgMitraCreateProduct)
    ImageView imgMitraCreateProduct;
    @BindView(R.id.etTitle)
    TextInputEditText etTitle;
    @BindView(R.id.etPrice)
    TextInputEditText etPrice;
    @BindView(R.id.etStock)
    TextInputEditText etStock;
    @BindView(R.id.etDescription)
    TextInputEditText etDescription;
    @BindView(R.id.btnUpload)
    RelativeLayout btnUpload;
    private Bitmap bitmap;
    @BindView(R.id.spinCategory)
    Spinner spinCategory;
    @BindView(R.id.btnStore)
    RelativeLayout btnStore;
    int category_id;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_create_product);
        ButterKnife.bind(this);
        String[] items = new String[]{"Baju", "Celana", "Sepatu"};
        String[] itemsId = new String[]{"1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinCategory.setAdapter(adapter);
        spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category_id = Integer.parseInt(itemsId[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tinyDB = new TinyDB(this);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i, 1);
            }
        });
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store();
            }
        });
    }

    private String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
//                Bundle extras = data.getExtras();
//                bitmap = (Bitmap) extras.get("data");
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imgMitraCreateProduct.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void store() {
        String captureFile = imageToString(bitmap);
        String title = etTitle.getText().toString().trim();
        String price = etPrice.getText().toString().trim();
        String stock = etStock.getText().toString().trim();
//        String description = etDescription.getText().toString().trim();
        String description = "coba";
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .productStore(
                        tinyDB.getString("token"),
                        title,
                        category_id,
                        Integer.parseInt(price),
                        Integer.parseInt(stock),
                        captureFile,
                        description
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MitraCreateProduct.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    finish();
                } else {
                    Toast.makeText(MitraCreateProduct.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(MitraCreateProduct.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
