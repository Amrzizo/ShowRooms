package com.codes.amr.showrooms.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codes.amr.showrooms.di.util.ViewModelKey;
import com.codes.amr.showrooms.ui.carview.CarViewDetailsViewModel;
import com.codes.amr.showrooms.ui.detials.CarDetailsViewModel;
import com.codes.amr.showrooms.ui.list.CarsListViewModel;
import com.codes.amr.showrooms.utils.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CarsListViewModel.class)
    abstract ViewModel bindListViewModel(CarsListViewModel carsListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CarDetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(CarDetailsViewModel carDetailsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CarViewDetailsViewModel.class)
    abstract ViewModel bindInteriorViewModel(CarViewDetailsViewModel interiorFragment);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
