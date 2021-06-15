package com.book.storiek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.book.storiek.Adapter.StoryAdapter;
import com.book.storiek.Database.Database;
import com.book.storiek.Model.Story;

import java.util.List;

public class MasalFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    StoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_main, container, false);
        setupViews();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupViews() {
        recyclerView = view.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Database db = new Database(getActivity());
        List<Story> storyList = db.getMasalStory();
        adapter = new StoryAdapter(getActivity(), storyList);
        recyclerView.setAdapter(adapter);
    }
}
