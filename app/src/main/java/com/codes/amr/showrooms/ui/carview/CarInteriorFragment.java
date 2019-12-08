package com.codes.amr.showrooms.ui.carview;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.codes.amr.showrooms.R;
import com.codes.amr.showrooms.base.BaseFragment;
import com.codes.amr.showrooms.utils.ViewModelFactory;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import javax.inject.Inject;

import butterknife.BindView;
import pl.rjuszczyk.panorama.gyroscope.FusedGyroscopeSensor;
import pl.rjuszczyk.panorama.viewer.PanoramaGLSurfaceView;


public class CarInteriorFragment extends BaseFragment {
    private FusedGyroscopeSensor gyroscopeObserver;
    @BindView(R.id.panorama)
    PanoramaGLSurfaceView panoramaView;


    @Override
    protected int layoutRes() {
        return R.layout.fragment_interior;
    }


    @Inject
    ViewModelFactory viewModelFactory;
    private CarViewDetailsViewModel carViewDetailsViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getBaseActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        carViewDetailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(CarViewDetailsViewModel.class);
        carViewDetailsViewModel.restoreFromBundle(savedInstanceState);

        showInterior();


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (carViewDetailsViewModel != null)
            carViewDetailsViewModel.saveToBundle(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        panoramaView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    private void showInterior() {

        carViewDetailsViewModel.getSelectedModel().observe(this, car -> {
            if (car != null) {

                VrPanoramaView.Options options = new VrPanoramaView.Options();

                try {

                    options.inputType = VrPanoramaView.Options.TYPE_MONO;
                    Glide.with(this)
                            .asBitmap()
                            .load(car.getInterior())
                            .into(new CustomTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                    panoramaView.setPanoramaBitmap(resource);

                                }

                                @Override
                                public void onLoadCleared(@Nullable Drawable placeholder) {
                                }
                            });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
