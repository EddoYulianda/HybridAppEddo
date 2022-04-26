package com.eddo.hybridappeddo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eddo.hybridappeddo.R;
import com.eddo.hybridappeddo.api.InsertAPI;
import com.eddo.hybridappeddo.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText name, pass, email, phone;
    Button btnRegister;
    String URL = "https://eddoyulianda.000webhostapp.com/";
    private static Retrofit retrofit = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        btnRegister = findViewById(R.id.btn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
            }
        });


    }

    private void insertdata() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InsertAPI insertAPI= retrofit.create(InsertAPI.class);
        Call<UserModel> call = insertAPI.insertdata(name.getText().toString(), pass.getText().toString(), email.getText().toString(), phone.getText().toString());

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                name.setText("");
                pass.setText("");
                email.setText("");
                phone.setText("");

                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}