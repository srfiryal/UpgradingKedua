package com.example.upgradingkedua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;
    private ArrayList<RestaurantModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_restaurant_main);

        addData();
    }

    private void addData() {
        arrayList = new ArrayList<>();
        arrayList.add(new RestaurantModel("Burger King", "8 Upland Dr, Del Sol Valley, CA", R.drawable.logo_burgerking));
        arrayList.add(new RestaurantModel("Genki Sushi", "7 Steppes Dr, Britechester, CA", R.drawable.logo_genkisushi));
        arrayList.add(new RestaurantModel("Starbucks", "2 Pier Dr, Windenburg, CA", R.drawable.logo_starbucks));
        arrayList.add(new RestaurantModel("Taco Bell", "5 Ophelia Drive, Willow Creek, CA", R.drawable.logo_tacobell));

        adapter = new RestaurantAdapter(arrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}