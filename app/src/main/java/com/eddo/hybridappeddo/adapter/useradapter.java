package com.eddo.hybridappeddo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddo.hybridappeddo.R;
import com.eddo.hybridappeddo.model.UserModel;

import java.util.List;

public class useradapter extends RecyclerView.Adapter<UserViewHolder>
{
    Context context;
    private List<UserModel> userList;

    public useradapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    //Untuk memanggil layout carduser
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carduser,parent,false);
        UserViewHolder uvh = new UserViewHolder(view );
        return uvh;
    }

    @Override
    //untuk mengisi masing - masing komponen di carduser
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel userModel = userList.get( position);
        holder.name.setText("Username : "+userModel.getUsername());
        holder.pass.setText("Password : "+userModel.getPassword());
        holder.email.setText("Email : "+userModel.getEmail());
        holder.phone.setText("Phone : "+userModel.getPhone());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
class UserViewHolder extends RecyclerView.ViewHolder{
    TextView id, name, pass, email, phone;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        // Komponen yang ada pada carduser.xml
        id=itemView.findViewById(R.id.userid);
        name=itemView.findViewById(R.id.username);
        pass=itemView.findViewById(R.id.password);
        email=itemView.findViewById(R.id.email);
        phone=itemView.findViewById(R.id.phone);
    }
}