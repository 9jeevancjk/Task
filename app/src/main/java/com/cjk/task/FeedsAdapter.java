package com.cjk.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.ViewHolder>{
    private Context context;

    private final ArrayList<FeedsModel>  FeedsModelArrayList;

    public FeedsAdapter(ArrayList<FeedsModel> FeedsModelArrayList){
        this.context = context;
        this.FeedsModelArrayList = FeedsModelArrayList;
    }

    @NonNull
    @Override
    public FeedsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_card, parent, false);
        return new ViewHolder(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedsAdapter.ViewHolder holder, int position) {
        FeedsModel model = FeedsModelArrayList.get(position);
        holder.ProfilePicture.setImageResource(model.getProfilePicture());
        holder.campusName.setText(model.getCampusName());
        holder.profileName.setText(model.getProfileName());
        holder.activityType.setText(model.getActivityType());
        holder.postDate.setText(model.getPostdate());
        holder.paragraph.setText(model.getParagraph());
        holder.PostImage.setImageResource(model.getPostImage());

    }

    @Override
    public int getItemCount() {
        return FeedsModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView ProfilePicture;
        private final ImageView PostImage;

        private final TextView campusName, profileName, activityType, postDate, paragraph;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ProfilePicture = itemView.findViewById(R.id.profile_picture);
            campusName = itemView.findViewById(R.id.campusName);
            profileName = itemView.findViewById(R.id.profileName);
            activityType = itemView.findViewById(R.id.activityType);
            postDate = itemView.findViewById(R.id.date_of_post);
            paragraph = itemView.findViewById(R.id.paragraph);
            PostImage = itemView.findViewById(R.id.imagePost);

        }
    }
}
