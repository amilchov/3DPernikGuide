package com.am.a3dpernikguide.view.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.db.PernikGuideDatabase;
import com.am.a3dpernikguide.graphics.view.ModelActivity;
import com.am.a3dpernikguide.model.api.finds.Finds;
import com.am.a3dpernikguide.model.db.FindsEntry;
import com.am.a3dpernikguide.retrofit.ApiService;
import com.am.a3dpernikguide.retrofit.ApiUtils;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class GoogleGeofenceActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private Serializable serializable;
    private ProgressDialog dialog;
    private Circle mCircle;
    private Marker mMarker;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private PernikGuideDatabase database;
    private List<FindsEntry> findsEntries;
    private View viewMarker;
    private View viewFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_geofence);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Виртуален археолог!");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        database = PernikGuideDatabase.getDatabase(PernikGuideApplication.getContext());

        compositeDisposable = new CompositeDisposable();
        apiService = ApiUtils.getService();

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        viewMarker = layoutInflater.inflate(R.layout.layout_info_marker, null ,false);
        viewFind = layoutInflater.inflate(R.layout.layout_find, null, false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMapSettings();

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(42.59443300217415, 23.0178432551987), 17));

        try {

            if (database.modelDao().loadFind() == null) {
                compositeDisposable.add(
                        apiService.loadFindsData(SharedPreferencesManager.getUserToken(PernikGuideApplication.getContext()))
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(this::getFindsData, throwable -> {}));
            } else {
                findsEntries = database.modelDao().loadFinds();

                for (int i=0; i<findsEntries.size(); i++) {
                    if (findsEntries.get(i).getPeriod().equals("Праисторически")) {
                        drawMarkerWithCircle(new LatLng(Double.parseDouble(findsEntries.get(i).getLatitude()),
                                        Double.parseDouble(findsEntries.get(i).getLongitude())),
                                BitmapDescriptorFactory.HUE_YELLOW, findsEntries.get(i).getName());
                    } else if (findsEntries.get(i).getPeriod().equals("Тракийски")) {
                        drawMarkerWithCircle(new LatLng(Double.parseDouble(findsEntries.get(i).getLatitude()),
                                        Double.parseDouble(findsEntries.get(i).getLongitude())),
                                105.0f, findsEntries.get(i).getName());
                    } else if (findsEntries.get(i).getPeriod().equals("Римски и византийски")) {
                        drawMarkerWithCircle(new LatLng(Double.parseDouble(findsEntries.get(i).getLatitude()),
                                        Double.parseDouble(findsEntries.get(i).getLongitude())),
                                BitmapDescriptorFactory.HUE_BLUE, findsEntries.get(i).getName());
                    } else if (findsEntries.get(i).getPeriod().equals("Средновековие")) {
                        drawMarkerWithCircle(new LatLng(Double.parseDouble(findsEntries.get(i).getLatitude()),
                                        Double.parseDouble(findsEntries.get(i).getLongitude())),
                                BitmapDescriptorFactory.HUE_RED, findsEntries.get(i).getName());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getFindsData(Response<Finds> response) {
        if (response.isSuccessful()) {
            for (int i=0; i<response.body().getFinds().size(); i++) {
                int idFind = response.body().getFinds().get(i).getFindId();
                int idUser = response.body().getFinds().get(i).getUserId();
                int status = response.body().getFinds().get(i).getStatus();
                String name = response.body().getFinds().get(i).getFind().getName();
                String desc = response.body().getFinds().get(i).getFind().getDescription();
                String imageUrl = response.body().getFinds().get(i).getFind().getImage();
                String material = response.body().getFinds().get(i).getFind().getMaterial();
                String period = response.body().getFinds().get(i).getFind().getPeriod();
                String latitude = response.body().getFinds().get(i).getFind().getLatitude();
                String longitude = response.body().getFinds().get(i).getFind().getLongitude();
                drawMarkerWithCircle(new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude)),
                        BitmapDescriptorFactory.HUE_GREEN, name);
//              System.out.println("Информация: " + desc);
                database.modelDao().insertFind(new FindsEntry(idFind, idUser, status, name, desc, imageUrl, material, period, latitude, longitude));
            }
        }
    }

    private void drawMarkerWithCircle(LatLng position, float color, String title){
        double radiusInMeters = 1.5;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        mCircle = googleMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(position).icon(BitmapDescriptorFactory.defaultMarker(color)).title(title);
        mMarker = googleMap.addMarker(markerOptions);
    }



    private void googleMapSettings() {
        // Changing map type
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Showing / hiding your current location
        googleMap.setMyLocationEnabled(true);

        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        // Enable / Disable my location button
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        // Enable / Disable Compass icon
        googleMap.getUiSettings().setCompassEnabled(true);

        // Enable / Disable Rotate gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        // Enable / Disable zooming functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.geofence, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info_geofence) {
            new AlertDialog.Builder(this)
                    .setView(viewMarker)
                    .setPositiveButton("ok", (dialogInterface, i) -> {
                        ((ViewGroup) viewMarker.getParent()).removeView(viewMarker);
                    })
                    .setCancelable(false)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}