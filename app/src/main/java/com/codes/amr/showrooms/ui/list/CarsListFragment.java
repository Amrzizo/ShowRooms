package com.codes.amr.showrooms.ui.list;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codes.amr.showrooms.R;
import com.codes.amr.showrooms.base.BaseFragment;
import com.codes.amr.showrooms.data.model.Car;
import com.codes.amr.showrooms.ui.detials.CarDetailsViewModel;
import com.codes.amr.showrooms.ui.detials.CarsDetailsFragment;
import com.codes.amr.showrooms.utils.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsListFragment extends BaseFragment implements ModelSelectedListener {

    @BindView(R.id.recyclerView)
    RecyclerView listView;
    @BindView(R.id.tv_error)
    TextView errorTextView;
    @BindView(R.id.loading_view)
    View loadingView;

    @Inject
    ViewModelFactory viewModelFactory;
    private CarsListViewModel viewModel;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_car_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getBaseActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CarsListViewModel.class);

        listView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        listView.setAdapter(new AllModelsListAdapter(viewModel, this, this));
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        observableViewModel();
    }

    @Override
    public void onModelSelected(Car car) {
        CarDetailsViewModel carDetailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(CarDetailsViewModel.class);
        carDetailsViewModel.setSelectedCar(car);
        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, new CarsDetailsFragment())
                .addToBackStack(null).commit();
    }

    private void observableViewModel() {
        viewModel.getData().observe(this, data -> {
            if (data != null) listView.setVisibility(View.VISIBLE);
        });

        viewModel.getError().observe(this, isError -> {
            if (isError != null) if (isError) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                errorTextView.setText("An Error Occurred While Loading Data!");
            } else {
                errorTextView.setVisibility(View.GONE);
                errorTextView.setText(null);
            }
        });

        viewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
    }
}
