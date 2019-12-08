package com.codes.amr.showrooms.ui.main;

import com.codes.amr.showrooms.ui.carview.CarExteriorFragment;
import com.codes.amr.showrooms.ui.carview.CarInteriorFragment;
import com.codes.amr.showrooms.ui.detials.CarsDetailsFragment;
import com.codes.amr.showrooms.ui.list.CarsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract CarsListFragment provideListFragment();

    @ContributesAndroidInjector
    abstract CarsDetailsFragment provideDetailsFragment();

    @ContributesAndroidInjector
    abstract CarInteriorFragment provideCarInteriorFragment();

    @ContributesAndroidInjector
    abstract CarExteriorFragment provideCarExteriorFragment();
}
