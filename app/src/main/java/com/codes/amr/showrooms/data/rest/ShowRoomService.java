package com.codes.amr.showrooms.data.rest;

import com.codes.amr.showrooms.data.model.responses.AllModelsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ShowRoomService {

    @GET("dev/api/api.php?function=allmodels")
    Single<AllModelsResponse> getAllCars();
}
