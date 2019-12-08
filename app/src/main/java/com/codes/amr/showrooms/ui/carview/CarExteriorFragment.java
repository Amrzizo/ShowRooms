package com.codes.amr.showrooms.ui.carview;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.codes.amr.showrooms.R;
import com.codes.amr.showrooms.base.BaseFragment;
import com.codes.amr.showrooms.utils.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;


public class CarExteriorFragment extends BaseFragment {
    @BindView(R.id.car_exterior_web_view)
    WebView carExteriorWebView;


    @Override
    protected int layoutRes() {
        return R.layout.fragment_exterior;
    }


    @Inject
    ViewModelFactory viewModelFactory;
    private CarViewDetailsViewModel carExteriorViewDetailsViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getBaseActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        carExteriorViewDetailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(CarViewDetailsViewModel.class);
        carExteriorViewDetailsViewModel.restoreFromBundle(savedInstanceState);

        showExterior();


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (carExteriorViewDetailsViewModel != null)
            carExteriorViewDetailsViewModel.saveToBundle(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    private void showExterior() {

        carExteriorViewDetailsViewModel.getSelectedModel().observe(this, car -> {
            if (car != null) {

                carExteriorWebView.getSettings().setJavaScriptEnabled(true);
                carExteriorWebView.loadUrl(car.getExterior());
            }

        });
    }


}
