package com.codes.amr.showrooms.ui.list;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codes.amr.showrooms.data.model.responses.AllModelsResponse;
import com.codes.amr.showrooms.data.rest.CarsRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CarsListViewModel extends ViewModel {

    private final CarsRepository carsRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<AllModelsResponse> data = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public CarsListViewModel(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
        disposable = new CompositeDisposable();
        fetchRepos();
    }

    LiveData<AllModelsResponse> getData() {
        return data;
    }

    LiveData<Boolean> getError() {
        return repoLoadError;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

    private void fetchRepos() {
        loading.setValue(true);
        disposable.add(carsRepository.getAllModels().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<AllModelsResponse>() {
                    @Override
                    public void onSuccess(AllModelsResponse value) {
                        repoLoadError.setValue(false);
                        data.setValue(value);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
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
