package com.iamtanshu.learnuidevelopment.BottomSheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.iamtanshu.learnuidevelopment.BottomSheet.Adapter.UserListAdapter;
import com.iamtanshu.learnuidevelopment.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyc_UserList;
    UserListAdapter adapter;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> mUserList = new ArrayList<>();
        mUserList.add("Sheshank Srivastava");
        mUserList.add("Piyush Khanna");
        mUserList.add("Tushar Garg");
        mUserList.add("Sahil Sharma");
        mUserList.add("Harshu Saini");
        mUserList.add("Nikhil Maurya");
        mUserList.add("Shubham Kumar");
        mUserList.add("Shivam Shukla");
        mUserList.add("Abhilash Kumar");
        mUserList.add("Rishab Anand");



        recyc_UserList = findViewById(R.id.recyc_UserList);
        manager = new LinearLayoutManager(this);
        adapter = new UserListAdapter(MainActivity.this, mUserList, new UserListAdapter.ItemClickListener() {
            @Override
            public void onClick(View v,int position) {
                ModalBottomSheet dialog = new ModalBottomSheet();
                Bundle data = new Bundle();
                data.putString("name",mUserList.get(position));
                dialog.setArguments(data);
                dialog.show(getSupportFragmentManager(),"ModelBottomSheet");

            }
        });
        recyc_UserList.setLayoutManager(manager);
        recyc_UserList.setAdapter(adapter);
    }
}