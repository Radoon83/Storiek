package com.book.storiek.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.storiek.ContentActivity;
import com.book.storiek.Model.Story;
import com.book.storiek.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Story> storyList;

    public StoryAdapter(Context context, List<Story> storyList) {
        this.context = context;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        //Bind data

        ItemViewHolder myViewHolder = (ItemViewHolder) viewHolder;
        myViewHolder.item.setAnimation(AnimationUtils.loadAnimation(context, R.anim.item_anim));
        myViewHolder.name.setText(storyList.get(i).getName());
        myViewHolder.field.setText(storyList.get(i).getField());

        Picasso.with(context).load(storyList.get(i).getImage()).resize(128, 128).into(myViewHolder.imageView);
        myViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("ID", storyList.get(i).getId());
                intent.putExtra("NAME", storyList.get(i).getName());
                intent.putExtra("FIELD", storyList.get(i).getField());
                intent.putExtra("DISC", storyList.get(i).getDisc());
                intent.putExtra("IMAGE", storyList.get(i).getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView name, field;
        CircleImageView imageView;
        RelativeLayout item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_id);
            name = itemView.findViewById(R.id.name_id);
            field = itemView.findViewById(R.id.field);
            item = itemView.findViewById(R.id.relative_id);
        }
    }

    public void filterList(List<Story> filterList) {
        storyList = filterList;
        notifyDataSetChanged();
    }
}
