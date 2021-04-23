package com.am.a3dpernikguide.view.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.contract.HomeContract;
import com.am.a3dpernikguide.databinding.FragmentHomeBinding;
import com.am.a3dpernikguide.presenter.HomePresenter;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.component.ComponentUtils.showAlertDialog;
import static com.am.a3dpernikguide.util.manager.DataManager.OK;
import static com.am.a3dpernikguide.util.manager.DataManager.REQUIRED_NETWORK;
import static com.am.a3dpernikguide.util.manager.DataManager.WAIT;
import static com.am.a3dpernikguide.util.manager.DataManager.WARNING;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * Home Fragment - contains four cardviews that will be described
 */
public class HomeFragment extends Fragment implements HomeContract.View {

    //View binding library - connect java class with xml design
    private FragmentHomeBinding binding;
    //Presenter field
    private HomePresenter presenter;


    //RxJava Composite disposable for async requests
    private CompositeDisposable compositeDisposable;

    //progress dialog for loading
    private ProgressDialog progressDialog;

    /**
     * This method is the central point of the Fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        progressDialog = new ProgressDialog(this.getContext());
        compositeDisposable = new CompositeDisposable();
        presenter = new HomePresenter(this, compositeDisposable);


        setUserGreetingMessage();
        showProgress();
        presenter.delegate();

        binding.btnSeen.setOnClickListener(this::onClick);

        return binding.getRoot();
    }

    private void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.nav_seen_finds);
    }

    /**
     * Method that show ProgressDialog
     */
    @Override
    public void showProgress() {
        progressDialog.setMessage(WAIT);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    /**
     * Method that create new thread to hide ProgressDialog after data is changed
     */
    @Override
    public void hideProgress() {
        new Handler().postDelayed(() -> progressDialog.cancel(), 1000);
    }

    /**
     * Method that generate AlertDialog with message for "No internet connection"
     */
    @Override
    public void failedInternetConnection() {
        showAlertDialog(this.getContext(), WARNING, REQUIRED_NETWORK, OK);
    }

    @Override
    public void setUserGreetingMessage() {
        binding.tvName.append(SharedPreferencesManager.getUserFirstName(PernikGuideApplication.getContext()) + " ");
        binding.tvName.append(SharedPreferencesManager.getUserLastName(PernikGuideApplication.getContext()) + "!");
    }

    @Override
    public void setUserFortressDataCount(String countVisit) {
        binding.tvCountVisitFortress.setText(countVisit);
        SharedPreferencesManager.setUserFortressCount(PernikGuideApplication.getContext(), countVisit);
    }

    @Override
    public void setUserFortressDataTime(String lastTimeVisit) {
        binding.tvTimeCountFortress.setText(lastTimeVisit);
        SharedPreferencesManager.setUserFortressLastVisit(PernikGuideApplication.getContext(), lastTimeVisit);
    }

    @Override
    public void setUserMuseumDataCount(String countVisit) {
        binding.tvCountVisitMuseum.setText(countVisit);
        SharedPreferencesManager.setUserMuseumCount(PernikGuideApplication.getContext(), countVisit);
    }

    @Override
    public void setUserMuseumDataTime(String lastTimeVisit) {
        binding.tvTimeCountMuseum.setText(lastTimeVisit);
        SharedPreferencesManager.setUserFortressLastVisit(PernikGuideApplication.getContext(), lastTimeVisit);
    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}
