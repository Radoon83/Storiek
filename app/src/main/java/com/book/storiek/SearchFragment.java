package com.book.storiek;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.book.storiek.Adapter.StoryAdapter;
import com.book.storiek.Database.Database;
import com.book.storiek.Model.Story;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    EditText editText;
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    StoryAdapter adapter;
    List<Story> storyList;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment, container, false);
        setupViews();
        setData();
        showBackground();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().trim().isEmpty()) {
                    showBackground();
                } else {
                    removeBackground();
                    filter(s.toString());
                }
            }
        });
        return view;
    }

    private void filter(String text) {
        List<Story> filterList = new ArrayList<>();

        for (Story story : storyList) {

            if (story.getName().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(story);
            }
        }
        adapter.filterList(filterList);
    }

    private void setData() {
        Database db = new Database(getActivity());
        storyList = db.getAllStory();
        adapter = new StoryAdapter(getActivity(), storyList);
        recyclerView.setAdapter(adapter);
    }

    private void showBackground() {
        linearLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    private void removeBackground() {
        linearLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void setupViews() {
        editText = view.findViewById(R.id.search_ed_id);
        linearLayout = view.findViewById(R.id.search_bg);
        recyclerView = view.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
