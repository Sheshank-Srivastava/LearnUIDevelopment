package com.iamtanshu.learnuidevelopment.SnackBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.iamtanshu.learnuidevelopment.R;

import java.lang.invoke.ConstantCallSite;

public class SnackBarActivity extends AppCompatActivity {
    Button btnDefault,btnCustomView,btnWithAction;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        constraintLayout = findViewById(R.id.rootLayout);
        btnDefault = findViewById(R.id.btn_Default);
        btnCustomView = findViewById(R.id.btn_CustonView);
        btnWithAction = findViewById(R.id.btn_ActionOne);


        //Button Click event for Default Snack Bar
        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar defaultBar = Snackbar.make(constraintLayout,"Default SnackBar", BaseTransientBottomBar.LENGTH_SHORT);
                defaultBar.show();
            }
        });
         //Button Click event for custom View Snack Bar
        btnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  Snackbar snackbar = Snackbar.make(constraintLayout,"",BaseTransientBottomBar.LENGTH_SHORT);
                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                View customView = getLayoutInflater().inflate(R.layout.custom_snack_bar,null);
                layout.setPadding(0,0,0,0);
                layout.addView(customView,0);
                snackbar.show();
            }
        });

        //Button with Action SnackBar
        btnWithAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar actionSnackBar = Snackbar.make(constraintLayout,"Action Snack Bar", BaseTransientBottomBar.LENGTH_SHORT);
                actionSnackBar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar responseSnackBar =Snackbar.make(constraintLayout,"Response to the action", BaseTransientBottomBar.LENGTH_SHORT);
                        responseSnackBar.show();
                    }
                });
                actionSnackBar.show();
            }
        });

    }
}