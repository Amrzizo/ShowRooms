package com.codes.amr.showrooms.ui.main;

import android.os.Bundle;

import com.codes.amr.showrooms.R;
import com.codes.amr.showrooms.base.BaseActivity;
import com.codes.amr.showrooms.ui.list.CarsListFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new CarsListFragment()).commit();
    }
}
