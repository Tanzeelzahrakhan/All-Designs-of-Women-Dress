package com.example.womandressdesigns;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.womandressdesigns.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {
ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.homeArrow.setOnClickListener(view -> {
            Intent intent=new Intent(HomeActivity.this,All_dress_design.class);
            startActivity(intent);
        });
        binding.sharingView.setOnClickListener(view -> shareContent());

    }

    private void shareContent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Sharing this content with others!");
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}