package com.example.womandressdesigns.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.womandressdesigns.Model.SliderModel;
import com.example.womandressdesigns.R;
import com.example.womandressdesigns.SavedActivity;
import com.example.womandressdesigns.databinding.ImageSliderLayoutItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.sliderViewHolder> {

    ArrayList<SliderModel> imageslist;

    public SliderAdapter(ArrayList<SliderModel> imageslist) {
        this.imageslist = imageslist;
    }

    @Override
    public sliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item,null);
        return new sliderViewHolder(view);
    }


    @Override
    public void onBindViewHolder(sliderViewHolder viewHolder, int position) {
        SliderModel imageRes = imageslist.get(position);

            viewHolder.binding.ivAutoImageSlider.setImageResource(imageRes.getImages());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewHolder.binding.ivAutoImageSlider.getContext(), SavedActivity.class);
                intent.putExtra("key",String.valueOf(imageslist.get(position).getImages()));
                viewHolder.binding.ivAutoImageSlider.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getCount() {
        return imageslist.size();
    }

    public class sliderViewHolder extends ViewHolder {
        ImageSliderLayoutItemBinding binding;
        public sliderViewHolder(View itemView) {
            super(itemView);
            binding=ImageSliderLayoutItemBinding.bind(itemView);
        }
    }
}
