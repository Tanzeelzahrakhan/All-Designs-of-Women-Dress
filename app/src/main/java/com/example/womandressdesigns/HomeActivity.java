package com.example.womandressdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.womandressdesigns.databinding.ActivityHomeBinding;
import com.example.womandressdesigns.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {
ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.homeArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,All_dress_design.class);
                startActivity(intent);
            }
        });
        binding.sharingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareContent();

            }
        });

    }

    private void shareContent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Sharing this content with others!");
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}