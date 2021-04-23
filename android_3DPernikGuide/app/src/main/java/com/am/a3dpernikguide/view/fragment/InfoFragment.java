package com.am.a3dpernikguide.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.am.a3dpernikguide.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class InfoFragment extends Fragment {

    FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setVisibility(View.GONE);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        floatingActionButton.setVisibility(View.VISIBLE);
    }
}
