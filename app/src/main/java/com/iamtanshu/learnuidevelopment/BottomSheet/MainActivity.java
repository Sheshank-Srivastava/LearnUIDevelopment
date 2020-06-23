package com.iamtanshu.learnuidevelopment.BottomSheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iamtanshu.learnuidevelopment.BottomSheet.Adapter.UserListAdapter;
import com.iamtanshu.learnuidevelopment.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyc_UserList;
    UserListAdapter adapter;
    LinearLayoutManager manager;
    List<String> mUserList = new ArrayList<>();

    //Declareing bottom Sheet variable
    BottomSheetBehavior bottomSheetBehavior;
    BottomSheetDialog bottomSheetDialog;
    View bottom_sheet, view;
    TextView txtUserName;
    ImageView imgClose;
    Button btn_PingMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUserList();
        setRecycler();
        showFloatingBottomSheet();
    }

    //Function inflater userlist
    private void setUserList() {
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
    }

    //Function setup recyclerView
    private void setRecycler() {

        recyc_UserList = findViewById(R.id.recyc_UserList);
        manager = new LinearLayoutManager(this);
        adapter = new UserListAdapter(MainActivity.this, mUserList, new UserListAdapter.ItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                txtUserName.setText(mUserList.get(position));
                bottomSheetDialog.show();
            }
        });
        recyc_UserList.setLayoutManager(manager);
        recyc_UserList.setAdapter(adapter);
    }

    //Function that set Floating Bottom Sheet
    public void showFloatingBottomSheet() {
        bottom_sheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        view = getLayoutInflater().inflate(R.layout.float_bottom_sheet, null);

        bottomSheetDialog = new BottomSheetDialog(this);

        bottomSheetDialog.setContentView(view);
//        bottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

        txtUserName = view.findViewById(R.id.txt_name);
        imgClose = view.findViewById(R.id.img_close);
        btn_PingMe = view.findViewById(R.id.btn_click);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

        btn_PingMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ping Me", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
    }


}