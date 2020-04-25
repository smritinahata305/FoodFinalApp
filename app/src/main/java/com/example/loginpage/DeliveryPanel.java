package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class DeliveryPanel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;

    String user_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_panel);

        drawerlayout = findViewById(R.id.drawer_layout);
        navigationview = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        //Add these 2 lines to get data from Login



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationview.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.current_order:
                Intent intent = new  Intent(DeliveryPanel.this,Current_Order.class);
                startActivity(intent);
                break;
            case R.id.avail_order:
                Intent intent2 = new  Intent(DeliveryPanel.this,Available_Order.class);
                startActivity(intent2);
                break;
            case R.id.profile:
                PassData();

        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void PassData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_radius = intent.getStringExtra("radius");
        String user_phoneNo = intent.getStringExtra("phone");
        String user_password = intent.getStringExtra("password");

        Intent intent_set = new Intent(DeliveryPanel.this, Settings_Del.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }
}
