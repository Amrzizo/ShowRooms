package com.codes.amr.showrooms.di.module;

import com.codes.amr.showrooms.ui.main.MainActivity;
import com.codes.amr.showrooms.ui.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
