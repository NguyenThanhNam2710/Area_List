package com.example.areasdk.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.areasdk.R;
import com.example.areasdk.constant.Constants;
import com.example.areasdk.databinding.ActivityAreaBinding;
import com.example.areasdk.viewmodel.AreaViewModel;
import com.google.android.material.snackbar.Snackbar;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG;

public class AreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAreaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_area);
        Intent intent = getIntent();
        String area = intent.getStringExtra("area");
        Toast.makeText(this, "Xác nhận địa chỉ:\n" + area, Toast.LENGTH_SHORT).show();
        binding.edtArea.setText(area);
        binding.setViewModel(new AreaViewModel(this, Constants.AreaType.CITY, ""));
    }
}