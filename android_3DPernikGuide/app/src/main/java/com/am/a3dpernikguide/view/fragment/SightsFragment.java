package com.am.a3dpernikguide.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.databinding.FragmentSightsBinding;
import com.am.a3dpernikguide.util.manager.DataManager;
import com.squareup.picasso.Picasso;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * Fragment class that navigate between two sights
 */
public class SightsFragment extends Fragment {

    //View binding data
    private FragmentSightsBinding binding;

    //Bundle that store data and navigate it.
    private Bundle bundle;

    /**
     * Central point for the fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSightsBinding.inflate(getLayoutInflater());
        bundle = new Bundle();
        binding.cardMuseum.setOnClickListener(this::navigateToMuseum);
        binding.cardFortress.setOnClickListener(this::navigateToFortress);

        Picasso.get().load(R.drawable.krepost_pernik).into(binding.imageViewFortress);
        Picasso.get().load(R.drawable.minen_muzei).into(binding.imageViewMuseum);


        return binding.getRoot();
    }

    /**
     * Method that navigate to Museum Sight
     * @param view
     */
    private void navigateToMuseum(View view) {
        DataManager.SIGHTS sight = DataManager.SIGHTS.MUSEUM;
        bundle.putString(String.valueOf(sight), String.valueOf(sight));
        Navigation.findNavController(view).navigate(R.id.nav_sight, bundle);
    }

    /**
     * Method that navigate to Fortress Sight
     * @param view
     */
    private void navigateToFortress(View view) {
        DataManager.SIGHTS sight = DataManager.SIGHTS.FORTRESS;
        bundle.putString(String.valueOf(sight), String.valueOf(sight));
        Navigation.findNavController(view).navigate(R.id.nav_sight, bundle);
    }
}
