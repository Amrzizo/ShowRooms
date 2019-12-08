package com.codes.amr.showrooms.ui.list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codes.amr.showrooms.R;
import com.codes.amr.showrooms.data.model.Car;
import com.codes.amr.showrooms.data.model.responses.AllModelsResponse;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllModelsListAdapter extends RecyclerView.Adapter<AllModelsListAdapter.CarsViewHolder> {

    private ModelSelectedListener modelSelectedListener;
    private AllModelsResponse data;
    public Context context;

    AllModelsListAdapter(CarsListViewModel viewModel, LifecycleOwner lifecycleOwner, ModelSelectedListener modelSelectedListener) {
        this.modelSelectedListener = modelSelectedListener;
        viewModel.getData().observe(lifecycleOwner, data -> {

            if (data != null) {
                this.data = data;
                notifyDataSetChanged();
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_car_list_item, parent, false);
        context = parent.getContext();
        return new CarsViewHolder(view, modelSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        holder.bind(data.getModels().get(position));
    }

    @Override
    public int getItemCount() {
        return data.getModels().size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static final class CarsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.car_type)
        TextView carTypeText;
        @BindView(R.id.car_img)
        ImageView carImage;

        private Car car;

        CarsViewHolder(View itemView, ModelSelectedListener modelSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (car != null) {
                    modelSelectedListener.onModelSelected(car);
                }
            });
        }

        void bind(Car car) {
            this.car = car;
            carTypeText.setText(Locale.getDefault().getDisplayLanguage().equalsIgnoreCase(Car.EN) ? car.getName_en() : car.getName_ar());

            Glide.with(itemView.getContext()).load(car.getModels_image()).into(carImage);
        }
    }
}
