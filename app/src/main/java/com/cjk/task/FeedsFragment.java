package com.cjk.task;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedsFragment extends Fragment {

    private RecyclerView feedsRV;
    private ProgressBar progressBarLoading;
    private FeedsAdapter feedsAdapter;

    public FeedsFragment() {
        // Required empty public constructor
    }

    TextView createPost, writePost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFeeds();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);
        createPost = view.findViewById(R.id.create);

        writePost = view.findViewById(R.id.writePost);
        writePost.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CreatePostActivity.class);
            startActivity(intent);
        });

        feedsRV = view.findViewById(R.id.feedsRV);
        progressBarLoading = view.findViewById(R.id.progressBar);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        feedsRV.setLayoutManager(layoutManager);

        ArrayList feedsData = new ArrayList<FeedsNote>();
        for (int i = 0; i < FeedsNoteInformation.id.length; i++) {
            feedsData.add(
                    new FeedsNote
                            (
                                    FeedsNoteInformation.id[i],
                                    FeedsNoteInformation.dateArray[i]
                            )
            );
        }
        feedsAdapter = new FeedsAdapter(feedsData);
        feedsRV.setAdapter(feedsAdapter);
        return view;
    }

    public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.ViewHolder> {

        private ArrayList<FeedsNote> feedsList;

        public FeedsAdapter(ArrayList<FeedsNote> feedsData) {
            this.feedsList = feedsData;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView date;
            public ViewHolder(View itemView) {
                super(itemView);
                this.date = (TextView) itemView.findViewById(R.id.date_of_post);
            }
        }

        @NonNull
        @Override
        public FeedsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_card, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FeedsAdapter.ViewHolder holder, int position) {
            holder.date.setText(feedsList.get(position).getDate());
            holder.itemView.setOnClickListener(view -> {
               // Toast.makeText(getActivity(), "Item " + position + "isclicked.", Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return feedsList.size();
        }
    }

    private void initFeeds() {
    }


}
