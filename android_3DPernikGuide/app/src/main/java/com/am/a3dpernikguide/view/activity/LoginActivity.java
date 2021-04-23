package com.am.a3dpernikguide.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.am.a3dpernikguide.databinding.ActivityLoginBinding;
import com.am.a3dpernikguide.databinding.LayoutLoginBinding;
import com.am.a3dpernikguide.contract.LoginContract;
import com.am.a3dpernikguide.presenter.LoginPresenter;

import io.reactivex.disposables.CompositeDisposable;

import static com.am.a3dpernikguide.util.component.ComponentUtils.showAlertDialog;
import static com.am.a3dpernikguide.util.component.ComponentUtils.showToast;
import static com.am.a3dpernikguide.util.manager.DataManager.OK;
import static com.am.a3dpernikguide.util.manager.DataManager.SUCCESS_LOGIN_USER;
import static com.am.a3dpernikguide.util.manager.DataManager.WAIT;
import static com.am.a3dpernikguide.util.manager.DataManager.WARNING;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * Login Activity - Main screen for login form.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    //View binding library
    private ActivityLoginBinding binding;
    private LayoutLoginBinding layoutLoginBinding;

    //RxJava Async request
    private CompositeDisposable compositeDisposable;
    private ProgressDialog progressDialog;

    //Presenter for the login view(LoginActivity)
    private LoginPresenter presenter;

    /**
     * Central point for the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //create objects
        compositeDisposable = new CompositeDisposable();
        progressDialog = new ProgressDialog(this);
        presenter = new LoginPresenter(this, compositeDisposable);

        //delegate with methods
        layoutLoginBinding = binding.layoutLogin;
        layoutLoginBinding.btnLogin.setOnClickListener(this::onClick);
        layoutLoginBinding.tvSingUp.setOnClickListener(this::textListener);
    }

    //Method that navigate to Register Screen
    private void textListener(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    //Class which navigate with LoginPresenter
    private void onClick(View view) {
        String email = layoutLoginBinding.etEmail.getText().toString().trim();
        String password = layoutLoginBinding.etPassword.getText().toString().trim();

        presenter.validateCredentials(email, password);
    }

    //Show progress dialog
    @Override
    public void showProgress() {
        progressDialog.setMessage(WAIT);
        progressDialog.show();
    }

    //hide progress
    @Override
    public void hideProgress() {
        progressDialog.cancel();
    }

    /**
     * Show error for email field
     * @param errorMessage
     */
    @Override
    public void showErrorEmail(String errorMessage) {
        layoutLoginBinding.etEmail.setError(errorMessage);
        layoutLoginBinding.etEmail.requestFocus();
    }

    /**
     * method which show password error field
     * @param errorMessage
     */
    @Override
    public void showErrorPassword(String errorMessage) {
        layoutLoginBinding.etPassword.setError(errorMessage);
        layoutLoginBinding.etPassword.requestFocus();
    }

    //while have success
    @Override
    public void onSuccess() {
        showToast(getApplicationContext(), SUCCESS_LOGIN_USER);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    //while faile request
    @Override
    public void onFailure(String errorMessage) {
        showAlertDialog(this, WARNING, errorMessage, OK);
    }

    //method which activate while activity destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
