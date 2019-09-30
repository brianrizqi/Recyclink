package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
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
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.CategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MitraCreateProduct extends AppCompatActivity {
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
    List<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_create_product);
        ButterKnife.bind(this);
        getCategory();
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
                Toast.makeText(MitraCreateProduct.this, String.valueOf(category_id), Toast.LENGTH_SHORT).show();
                store();
            }
        });
    }

    private void getCategory() {
        Call<CategoryResponse> call = Service
                .getInstance()
                .getAPI()
                .category();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                list = response.body().getData();
                ArrayAdapter<Category> adapter = new ArrayAdapter<Category>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinCategory.setAdapter(adapter);
//                spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        Category category = (Category) spinCategory.getSelectedItem();
//                        displayCategory(category);
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(MitraCreateProduct.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayCategory(Category category) {
        category_id = category.getId();
    }

    private String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                Glide.with(this)
                        .load(bitmap)
                        .into(imgMitraCreateProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void store() {
        String thumbnail = imageToString(bitmap);
        String title = etTitle.getText().toString();
        String price = etPrice.getText().toString();
        String stock = etStock.getText().toString();
        String description = etDescription.getText().toString();
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .productStore(
                        title,
                        category_id,
                        price,
                        stock,
                        thumbnail,
                        description
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.isSuccessful()) {
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
