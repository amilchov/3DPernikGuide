package com.am.a3dpernikguide.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.holder.SeenFindsHolder;
import com.am.a3dpernikguide.model.db.ModelEntry;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class SeenFindsAdapter extends RecyclerView.Adapter<SeenFindsHolder>{

    private List<ModelEntry> entryList;
    private Bundle bundle;

    public SeenFindsAdapter(List<ModelEntry> entryList) {
        this.entryList = entryList;
    }

    @NonNull
    @Override
    public SeenFindsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_seen, parent, false);
        return new SeenFindsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeenFindsHolder holder, int position) {
        ModelEntry entry = entryList.get(position);
        bundle = new Bundle();
        System.out.println(position);
        System.out.println(entryList.size());

        for (int i = 0; i < entryList.size(); i++) {
            System.out.println(entryList.get(i).getTitle());
        }
        holder.textViewCard.setText(entry.getTitle());
        Picasso.get().load(entry.getImagePath()).into(holder.imageView);
        System.out.println(entry.getImagePath());
//        holder.imageView.setImageResource(R.drawable.big_church);
        holder.linearLayout.setOnClickListener(view -> {
            bundle.putString("image", entry.getImagePath());
            bundle.putString("title", entry.getTitle());
            bundle.putString("description", entry.getDescription());
            bundle.putString("image_path", entry.getImagePath());
            bundle.putString("path", entry.getPath());
            Navigation.findNavController(view).navigate(R.id.nav_seen_find, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }
}
