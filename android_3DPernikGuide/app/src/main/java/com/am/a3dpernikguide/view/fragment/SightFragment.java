package com.am.a3dpernikguide.view.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.contract.SightContract;
import com.am.a3dpernikguide.databinding.FragmentSightBinding;
import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;
import com.am.a3dpernikguide.presenter.SightPresenter;
import com.am.a3dpernikguide.util.component.ComponentUtils;
import com.am.a3dpernikguide.util.manager.DataManager;
import com.am.a3dpernikguide.view.activity.GoogleGeofenceActivity;
import com.am.a3dpernikguide.view.activity.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.component.ComponentUtils.showAlertDialog;
import static com.am.a3dpernikguide.util.manager.DataManager.OK;
import static com.am.a3dpernikguide.util.manager.DataManager.REQUIRED_NETWORK;
import static com.am.a3dpernikguide.util.manager.DataManager.WAIT;
import static com.am.a3dpernikguide.util.manager.DataManager.WARNING;


/**
 * A simple {@link Fragment} subclass.
 *
 * Sight Fragment - contains all data for one sight.
 */
public class SightFragment extends Fragment implements SightContract.View {

    //View binding library - connect java class with xml design
    private FragmentSightBinding binding;

    //RxJava Composite disposable for async requests
    private CompositeDisposable compositeDisposable;

    //ProgressDialog for showing loading screen
    private ProgressDialog progressDialog;

    //Presenter field
    private SightPresenter presenter;

    private MapView map;

    private GoogleMap googleMap;

    private Dialog viewAlertDialog;

    private View viewPlay;

    private MediaController mediaController;

    private VideoView videoView;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return {@link View}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSightBinding.inflate(getLayoutInflater());

        compositeDisposable = new CompositeDisposable();
        progressDialog = new ProgressDialog(getContext());
        presenter = new SightPresenter(this, compositeDisposable);

        LayoutInflater layoutInflaterVideo = LayoutInflater.from(getActivity());
        viewPlay = layoutInflaterVideo.inflate(R.layout.layout_video, null ,false);

//        MapsInitializer.initialize(getActivity());
//        map = viewAlertDialog.findViewById(R.id.map);
//        map.onCreate(savedInstanceState);
//        map.onResume();



        videoView = viewPlay.findViewById(R.id.vv_fortress);
        mediaController = new MediaController(this.getContext());

        if (ActivityCompat.checkSelfPermission(PernikGuideApplication.getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(PernikGuideApplication.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setHasOptionsMenu(true);
        setTitleActionBar();
        setImage();
        hideFab();

        //check if data is museum or fortress
        if (checkData().equals(DataManager.SIGHTS.MUSEUM)) {
            showProgress();
            presenter.delegateMuseum();
            binding.btnScan.setVisibility(View.GONE);
        } else {
            showProgress();
            binding.btnScan.setVisibility(View.VISIBLE);
            binding.btnScan.setOnClickListener(this::onClick);
            presenter.delegateFortress();
        }

        return binding.getRoot();
    }

    private void onClick(View view) {
        startActivity(new Intent(getContext(), GoogleGeofenceActivity.class));
    }

    //Set image (Fortress or Museum)
    @Override
    public void setImage() {
        if (checkData().equals(DataManager.SIGHTS.MUSEUM)) {
            Picasso.get().load(R.drawable.minen_muzei).into(binding.imageSight);
        } else {
            Picasso.get().load(R.drawable.krepost_pernik).into(binding.imageSight);
        }
    }

    //Hide FabButton, because he hide the content
    @Override
    public void hideFab() {
        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setVisibility(View.INVISIBLE);
    }

    //show FabButton after close the Fragment
    @Override
    public void showFab() {
        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setVisibility(View.VISIBLE);
    }

    //Show loading ProgressDialog
    @Override
    public void showProgress() {
        progressDialog.setMessage(WAIT);
        progressDialog.show();
    }

    //Hide loading ProgressDialog
    @Override
    public void hideProgress() {
        progressDialog.cancel();
    }

    //Show AlertDialog for no internet connection
    @Override
    public void failedInternetConnection() {
        showAlertDialog(this.getContext(), WARNING, REQUIRED_NETWORK, OK);
    }

    /**
     * Set Data to museum
     * @param count
     * @param time
     * @param data
     */
    @Override
    public void setDataMuseum(String count, String time, List<BarChartDataMuseum> data) {
        //set data to count textfield
        binding.tvCountVisit.setText(count);
        //set data to last time visit textfield
        binding.tvTimeCount.setText(time);
        //create barChart
        ComponentUtils.createChart(binding.chartUser, null, data);
    }

    /**
     * Set data to fotress
     * @param count
     * @param time
     * @param data
     */
    @Override
    public void setDataFortress(String count, String time, List<BarChatDataFortress> data) {
        //set data to count textfield
        binding.tvCountVisit.setText(count);
        //set data to last time visit textfield
        binding.tvTimeCount.setText(time);
        //create barChart
        ComponentUtils.createChart(binding.chartUser, data, null);
    }

    //Set Title for ActionBar
    @Override
    public void setTitleActionBar() {
        if (checkData().equals(DataManager.SIGHTS.MUSEUM)) {
            ((MainActivity) getActivity())
                    .getSupportActionBar()
                    .setTitle(getResources().getString(R.string.museum_title));
        } else if (checkData().equals(DataManager.SIGHTS.FORTRESS)){
            ((MainActivity) getActivity())
                    .getSupportActionBar()
                    .setTitle(getResources().getString(R.string.fortress_title));
        }
    }

    //Create options Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.info_sights, menu);
        boolean museum = checkData().equals(DataManager.SIGHTS.MUSEUM);
        boolean fortress = checkData().equals(DataManager.SIGHTS.FORTRESS);

        if (museum) {
            menu.findItem(R.id.action_video).setVisible(false);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    //Selected info icon for information
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean museum = checkData().equals(DataManager.SIGHTS.MUSEUM);
        boolean fortress = checkData().equals(DataManager.SIGHTS.FORTRESS);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        if (id == R.id.action_info) {
            if (museum) {
                showAlertDialog(this.getContext(),
                        getResources().getString(R.string.museum_title),
                        getResources().getString(R.string.museum_info), OK);
            } else if (fortress){
                showAlertDialog(this.getContext(),
                        getResources().getString(R.string.fortress_title),
                        getResources().getString(R.string.fortress_info), OK);
            }
        } else if(id == R.id.action_location) {
            if (museum){
                locationMuseumMap();
            } else if (fortress){
                locationFortressMap();
            }
        } else if(id == R.id.action_video) {
             builder
                    .setView(viewPlay)
                    .setPositiveButton("ok", (dialogInterface, i) -> {
                        ((ViewGroup) viewPlay.getParent()).removeView(viewPlay);
                    })
                    .setCancelable(false)
                    .show();
            String videoPath = "android.resource://" + getActivity().getApplicationContext().getPackageName() + "/" + R.raw.krakra_fly;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
            videoView.start();
        }
        return super.onOptionsItemSelected(item);
    }

    private void locationMuseumMap() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_map);
        dialog.setCancelable(true);
        dialog.setTitle("hi");
        dialog.show();

        MapView mMapView = (MapView) dialog.findViewById(R.id.map);
        MapsInitializer.initialize(getActivity());

        mMapView = (MapView) dialog.findViewById(R.id.map);
        mMapView.onCreate(dialog.onSaveInstanceState());
        mMapView.onResume();// needed to get the map to display immediately
        mMapView.getMapAsync(mMap -> {
            googleMap = mMap;

            // For showing a move to my location button
            googleMap.setMyLocationEnabled(true);

            // For dropping a marker at a point on the Map
            LatLng sydney = new LatLng(42.609532,23.029032);
            googleMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .title(getResources()
                            .getString(R.string.museum_title)));

            // For zooming automatically to the location of the marker
            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        });
    }

    private void locationFortressMap() {

        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_map);
        dialog.setCancelable(true);
        dialog.setTitle("hi");
        dialog.show();

        MapView mMapView = (MapView) dialog.findViewById(R.id.map);
        MapsInitializer.initialize(getActivity());

        mMapView = (MapView) dialog.findViewById(R.id.map);
        mMapView.onCreate(dialog.onSaveInstanceState());
        mMapView.onResume();// needed to get the map to display immediately
        mMapView.getMapAsync(mMap -> {
            googleMap = mMap;

            // For showing a move to my location button
            googleMap.setMyLocationEnabled(true);

            // For dropping a marker at a point on the Map
            LatLng sydney = new LatLng(42.59443300217415, 23.0178432551987);
            googleMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .title(getResources()
                            .getString(R.string.fortress_title)));

            // For zooming automatically to the location of the marker
            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        });
    }

    /**
     * Method that get Sight from enum class
     * @return {@link DataManager.SIGHTS}
     */
    private DataManager.SIGHTS checkData() {
         DataManager.SIGHTS museum = DataManager.SIGHTS.MUSEUM;
         DataManager.SIGHTS fortress = DataManager.SIGHTS.FORTRESS;
        if (getArguments() != null) {
            if (Objects.equals(getArguments().getString(String.valueOf(museum)), String.valueOf(museum))) {
                return DataManager.SIGHTS.MUSEUM;
            }
        }
        return DataManager.SIGHTS.FORTRESS;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        showFab();
    }
}
