package com.example.bai1tuan4;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bai1tuan4.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int[] imageArray ={R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background};
    private int[] bgColor = {R.color.black,R.color.white};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Khoi tao viewbinding
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Load Random Image
        Random random = new Random();
        int randomImage = imageArray[random.nextInt(imageArray.length)];
        binding.bgView.setBackgroundResource(randomImage);
        //Click Change
        binding.changeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.getRoot().setBackgroundColor(Color.BLACK);
                    binding.changeSwitch.setTextColor(Color.WHITE);
                }
                else {
                    binding.getRoot().setBackgroundColor(Color.WHITE);
                    binding.changeSwitch.setTextColor(Color.BLACK);
                }
            }
        });
    }
}