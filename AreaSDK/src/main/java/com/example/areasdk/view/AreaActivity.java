package com.example.areasdk.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.areasdk.R;
import com.example.areasdk.constant.Constants;
import com.example.areasdk.databinding.ActivityAreaBinding;
import com.example.areasdk.viewmodel.AreaViewModel;

public class AreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAreaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_area);
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("Key_1");
        String value2 = intent.getStringExtra("Key_2");
        binding.setAreaViewModel(new AreaViewModel(this, value1, value2));
    }
}