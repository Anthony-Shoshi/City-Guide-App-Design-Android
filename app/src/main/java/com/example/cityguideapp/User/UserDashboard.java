package com.example.cityguideapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.cityguideapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    RecyclerView feature_recycler, most_viewed_recycler, categories_recycler;
    RecyclerView.Adapter featuredLocationAdapter, mostViewedAdapter, categoryAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView drawer_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);
        feature_recycler = (RecyclerView) findViewById(R.id.featured_recycler);
        most_viewed_recycler = (RecyclerView) findViewById(R.id.most_viewd_recycler);
        categories_recycler = (RecyclerView) findViewById(R.id.categories_recycler);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        drawer_menu = (ImageView) findViewById(R.id.drawer_menu);
        navigationView = (NavigationView) findViewById(R.id.navigation_view_id);

        navigationFunc();

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }

    private void navigationFunc() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home_menu);

        drawer_menu.setOnClickListener(this);
    }

    private void categoriesRecycler() {
        categories_recycler.setHasFixedSize(true);
        categories_recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categoriesHelperData = new ArrayList<>();
        categoriesHelperData.add(new CategoriesHelperClass(R.drawable.restaurant_icon, "Restaurants", getResources().getColor(R.color.card1)));
        categoriesHelperData.add(new CategoriesHelperClass(R.drawable.shop_icon, "Shops", getResources().getColor(R.color.card2)));
        categoriesHelperData.add(new CategoriesHelperClass(R.drawable.school_icon, "Schools", getResources().getColor(R.color.card3)));
        categoriesHelperData.add(new CategoriesHelperClass(R.drawable.bank_icon, "Banks", getResources().getColor(R.color.card4)));

        categoryAdapter = new CategoriesAdapter(categoriesHelperData);
        categories_recycler.setAdapter(categoryAdapter);
    }

    private void mostViewedRecycler() {
        most_viewed_recycler.setHasFixedSize(true);
        most_viewed_recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedHelperData = new ArrayList<>();
        mostViewedHelperData.add(new MostViewedHelperClass(R.drawable.paris, "Aifel Tower", "The most gorgeous view of Aifel Tower located in France."));
        mostViewedHelperData.add(new MostViewedHelperClass(R.drawable.mcdonald, "McDonalds", "Hello here delicious burgers are available."));
        mostViewedHelperData.add(new MostViewedHelperClass(R.drawable.status, "Statue of Liberty", "The most visited statue situated in USA."));

        mostViewedAdapter = new MostViewedAdapter(mostViewedHelperData);
        most_viewed_recycler.setAdapter(mostViewedAdapter);
    }

    private void featuredRecycler() {
        feature_recycler.setHasFixedSize(true);
        feature_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald, "McDonald's", "Hello here delicious burgers are available."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.status, "Statue of Liberty", "The most visited statue situated in USA."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.paris, "Aifel Tower", "The most gorgeous view of Aifel Tower located in France."));

        featuredLocationAdapter = new FeaturedAdapter(featuredLocations);
        feature_recycler.setAdapter(featuredLocationAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onClick(View v) {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
