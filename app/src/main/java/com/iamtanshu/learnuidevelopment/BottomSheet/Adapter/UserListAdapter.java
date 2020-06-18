package com.iamtanshu.learnuidevelopment.BottomSheet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamtanshu.learnuidevelopment.R;

import java.util.List;

import static com.iamtanshu.learnuidevelopment.R.drawable.testimage;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    Context context;
    List<String> mUserList;
    ItemClickListener listener;

    public UserListAdapter(Context context, List<String> mUserList,ItemClickListener clickListener) {
        this.context = context;
        this.mUserList = mUserList;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userlist_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listener.onClick(v, holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtUserName.setText(mUserList.get(position));
        holder.imgUserImage.setImageDrawable(context.getResources().getDrawable(testimage));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserName;
        ImageView imgUserImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txt_userName);
            imgUserImage = itemView.findViewById(R.id.img_UserImage);
        }
    }

    public interface ItemClickListener {
        void onClick(View v,int position);
    }

}
