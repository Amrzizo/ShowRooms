package com.codes.amr.showrooms.ui.detials;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.codes.amr.showrooms.R;
import com.codes.amr.showrooms.base.BaseFragment;
import com.codes.amr.showrooms.ui.carview.CarExteriorFragment;
import com.codes.amr.showrooms.ui.carview.CarInteriorFragment;
import com.codes.amr.showrooms.ui.carview.CarViewDetailsViewModel;
import com.codes.amr.showrooms.utils.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsDetailsFragment extends BaseFragment {

    @BindView(R.id.car_price)
    TextView carPriceTextView;
    @BindView(R.id.model_value)
    TextView carModelTextView;
    @BindView(R.id.interior_image)
    ImageView interiorImageView;
    @BindView(R.id.exterior_image)
    ImageView exteriorImageView;
    @BindView(R.id.selected_car_img)
    ImageView carImage;


    @Inject
    ViewModelFactory viewModelFactory;
    private CarDetailsViewModel carDetailsViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_car_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getBaseActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        carDetailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(CarDetailsViewModel.class);
        carDetailsViewModel.restoreFromBundle(savedInstanceState);
        displayCar();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (carDetailsViewModel != null)
            carDetailsViewModel.saveToBundle(outState);
    }

    private void displayCar() {
        carDetailsViewModel.getSelectedModel().observe(this, car -> {
            if (car != null) {

                Glide.with(getBaseActivity()).load(car.getModels_image()).into(carImage);
                carPriceTextView.setText(car.getPrice().toString() + " " + getString(R.string.str_kwd_txt));
                carModelTextView.setText(car.getYearModel());

                interiorImageView.setOnClickListener(v -> {
                    if (car != null) {

                        CarViewDetailsViewModel carInteriorViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(CarViewDetailsViewModel.class);
                        carInteriorViewModel.setSelectedCar(car);
                        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, new CarInteriorFragment())
                                .addToBackStack(null).commit();
                    }
                });

                exteriorImageView.setOnClickListener(v -> {
                    if (car != null) {

                        CarViewDetailsViewModel carExteriorViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(CarViewDetailsViewModel.class);
                        carExteriorViewModel.setSelectedCar(car);
                        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, new CarExteriorFragment())
                                .addToBackStack(null).commit();
                    }
                });

            }
        });


    }


}
