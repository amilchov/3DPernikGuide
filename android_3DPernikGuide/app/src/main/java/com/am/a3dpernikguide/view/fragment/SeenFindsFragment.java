package com.am.a3dpernikguide.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.adapter.SeenFindsAdapter;
import com.am.a3dpernikguide.databinding.FragmentSeenFindsBinding;
import com.am.a3dpernikguide.db.PernikGuideDatabase;
import com.am.a3dpernikguide.model.db.ModelEntry;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeenFindsFragment extends Fragment {

    private FragmentSeenFindsBinding binding;

    private PernikGuideDatabase database;

    private List<ModelEntry> entries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSeenFindsBinding.inflate(getLayoutInflater());

        database = PernikGuideDatabase.getDatabase(PernikGuideApplication.getContext());
        entries = database.modelDao().loadModels(SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext()));

        initRecyclerView();


        return binding.getRoot();
    }

    private void initRecyclerView() {
        SeenFindsAdapter adapter = new SeenFindsAdapter(entries);
        if (adapter.getItemCount() == 0) {
            binding.tvEmpty.setVisibility(View.VISIBLE);
        } else {
            binding.recyclerView.setHasFixedSize(true);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerView.setItemViewCacheSize(0);
            binding.recyclerView.setAdapter(adapter);
        }
    }
}
