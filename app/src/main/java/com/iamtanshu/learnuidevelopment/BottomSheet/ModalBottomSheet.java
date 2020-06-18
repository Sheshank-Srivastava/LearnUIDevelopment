package com.iamtanshu.learnuidevelopment.BottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.iamtanshu.learnuidevelopment.R;

public class ModalBottomSheet extends BottomSheetDialogFragment {

    View view;
    TextView txt_UserName;
    Button btn_close,btn_details;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.bottom_simple_details, container, false);
        txt_UserName = view.findViewById(R.id.bottom_UserName);
        btn_close = view.findViewById(R.id.btn_close);
        btn_details = view.findViewById(R.id.btn_details);
        String name = getArguments().getString("name");
        txt_UserName.setText(name);


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btn_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Details",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return view;
    }


}
