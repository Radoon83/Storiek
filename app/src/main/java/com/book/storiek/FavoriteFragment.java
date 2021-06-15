package com.book.storiek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.book.storiek.Adapter.FavAdapter;
import com.book.storiek.Adapter.StoryAdapter;
import com.book.storiek.Database.Database;
import com.book.storiek.Model.Story;

import java.util.List;

public class FavoriteFragment extends Fragment {

    View view;
    FavAdapter adapter;
    RecyclerView recyclerView;
    LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorite_fragment, container, false);
        setupViews();
        return view;
    }

    private void setupViews() {
        recyclerView = view.findViewById(R.id.recycler_id);
        linearLayout = view.findViewById(R.id.favorite_bg);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Database db = new Database(getActivity());
        List<Story> storyList = db.getFavStory();
        adapter = new FavAdapter(getActivity(), storyList);

        if (storyList.isEmpty()) {
            showBackground();
        } else {
            removeBackground();
        }

        recyclerView.setAdapter(adapter);
    }


    private void removeBackground() {
        linearLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void showBackground() {
        linearLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
