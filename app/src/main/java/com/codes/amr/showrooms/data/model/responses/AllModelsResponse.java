package com.codes.amr.showrooms.data.model.responses;

import com.codes.amr.showrooms.data.model.Car;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AllModelsResponse implements Serializable {

    private String status;
    private String message;
    @SerializedName("data")
    private ArrayList<Car> models;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Car> getModels() {
        return models;
    }

    public void setModels(ArrayList<Car> models) {
        this.models = models;
    }
}
