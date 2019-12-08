package com.codes.amr.showrooms.data.rest;

import com.codes.amr.showrooms.data.model.responses.AllModelsResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class CarsRepository {

    private final ShowRoomService showRoomService;

    @Inject
    public CarsRepository(ShowRoomService showRoomService) {
        this.showRoomService = showRoomService;
    }

    public Single<AllModelsResponse> getAllModels() {
        return showRoomService.getAllCars();

    }
}
