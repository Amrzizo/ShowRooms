package com.codes.amr.showrooms.ui.detials;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codes.amr.showrooms.data.model.Car;
import com.codes.amr.showrooms.data.rest.CarsRepository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CarDetailsViewModel extends ViewModel {

    private final CarsRepository carsRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<Car> selectedCar = new MutableLiveData<>();

    public LiveData<Car> getSelectedModel() {
        return selectedCar;
    }

    @Inject
    public CarDetailsViewModel(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
        disposable = new CompositeDisposable();
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar.setValue(selectedCar);
    }

    public void saveToBundle(Bundle outState) {
        if (selectedCar.getValue() != null) {
            outState.putStringArray("car_details", new String[]{
                    selectedCar.getValue().getModels_type(),
                    selectedCar.getValue().getCarName()
            });
        }
    }

    public void restoreFromBundle(Bundle savedInstanceState) {
        if (selectedCar.getValue() == null) {
            if (savedInstanceState != null && savedInstanceState.containsKey("repo_details")) {

            }
        }
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
