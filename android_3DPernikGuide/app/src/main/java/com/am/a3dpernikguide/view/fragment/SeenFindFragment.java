package com.am.a3dpernikguide.view.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.databinding.FragmentSeenFindBinding;
import com.am.a3dpernikguide.graphics.view.ModelActivity;
import com.am.a3dpernikguide.view.activity.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class SeenFindFragment extends Fragment {

    private FragmentSeenFindBinding binding;
    private FloatingActionButton floatingActionButton;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSeenFindBinding.inflate(getLayoutInflater());

        ((MainActivity) getActivity())
                .getSupportActionBar()
                .setTitle(getArguments().getString("title"));

        Picasso.get().load(getArguments().getString("image")).into(binding.imageSeenFind);

        binding.tvTopic.setText(getArguments().getString("title"));
        binding.tvDescription.setText(getArguments().getString("description"));
        System.out.println(getArguments().getString("description"));

        if (getArguments().getString("title").equals("Рудничен хаспел „Сименс“")) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.haspel);
            binding.cardViewMedia.setVisibility(View.VISIBLE);
        }else if (getArguments().getString("title").equals("Крепостна стена")) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.kamenna_stena);
            binding.cardViewMedia.setVisibility(View.VISIBLE);
        }

        floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setVisibility(View.GONE);

        binding.btnMediaStart.setOnClickListener(v -> {
            mediaPlayer.start();
        });

        binding.btnMediaPause.setOnClickListener(v -> {
            mediaPlayer.pause();
        });

        binding.btnMediaStop.setOnClickListener(v -> {
          mediaPlayer.stop();
        });

        binding.btnModel.setOnClickListener(v -> {
            startModelActivity();
        });

        return binding.getRoot();
    }

    private void startModelActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("uri", getArguments().getString("path"));
        Intent intent = new Intent(this.getContext(), ModelActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        floatingActionButton.setVisibility(View.VISIBLE);
    }

}
