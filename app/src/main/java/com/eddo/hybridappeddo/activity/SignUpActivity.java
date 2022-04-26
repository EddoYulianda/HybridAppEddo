package com.eddo.hybridappeddo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddo.hybridappeddo.R;
import com.eddo.hybridappeddo.adapter.useradapter;
import com.eddo.hybridappeddo.api.RetrofitServer;
import com.eddo.hybridappeddo.model.UserModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<UserModel> userModelList = new ArrayList<>();
    private useradapter userAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recUser);
        fab = findViewById(R.id.btnAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        userAdapter = new useradapter(this, userModelList);
        recyclerView.setAdapter(userAdapter);
        showDataUser();
    }

    private void showDataUser() {
        progressBar.setVisibility(View.VISIBLE);
        RetrofitServer.getselectAPI().callModel().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if(response.isSuccessful()&& response.body()!=null){
                    userModelList.addAll(response.body());
                    userAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Toast.makeText(SignUpActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


}
