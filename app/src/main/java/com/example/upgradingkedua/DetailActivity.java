package com.example.upgradingkedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private Bundle bundle;
    private String restaurant, address;
    private int image;
    private TextView tvRestaurant, tvAddress;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvRestaurant = findViewById(R.id.tv_restaurant_detail);
        tvAddress = findViewById(R.id.tv_address_detail);
        imgLogo = findViewById(R.id.img_logo_detail);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            restaurant = bundle.getString("restaurant");
            address = bundle.getString("address");
            image = bundle.getInt("image");
        }

        tvRestaurant.setText(restaurant);
        tvAddress.setText(address);
        imgLogo.setImageResource(image);
    }
}