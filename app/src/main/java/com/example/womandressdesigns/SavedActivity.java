package com.example.womandressdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.womandressdesigns.databinding.ActivitySavedBinding;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class SavedActivity extends AppCompatActivity {

ActivitySavedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        binding=ActivitySavedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       /* int saveImg=getIntent().getIntExtra("key",0);
        binding.imageView1.setImageResource(saveImg);
*/
        String value = getIntent().getStringExtra("key");

        binding.imageView1.setImageResource(Integer.parseInt(value));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), Integer.parseInt(value));



      binding.Save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


              String displayName = "MyImage.jpg";
              String mimeType = "image/jpeg";

              ContentValues values = new ContentValues();
              values.put(MediaStore.Images.Media.DISPLAY_NAME, displayName);
              values.put(MediaStore.Images.Media.MIME_TYPE, mimeType);

              if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                  values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);
              } else {
                  String imagePath = Environment.getExternalStorageDirectory().toString() + File.separator + Environment.DIRECTORY_PICTURES;
                  values.put(MediaStore.Images.Media.DATA, imagePath);
              }

              ContentResolver resolver = getContentResolver();
              Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

              OutputStream outputStream;
              try {
                  outputStream = resolver.openOutputStream(imageUri);
                  bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                  outputStream.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }




              Toast.makeText(SavedActivity.this, "KURKURAY KA PACKET DONE!", Toast.LENGTH_SHORT).show();





          }
      });



    }
}