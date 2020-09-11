package com.example.area_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.area_list.databinding.ActivityCityBinding;
import com.example.areasdk.constant.Constants;
import com.example.areasdk.viewmodel.AreaViewModel;

public class CITYActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_city);
        binding.setViewModel(new AreaViewModel(this, Constants.AreaType.CITY, ""));
    }


}