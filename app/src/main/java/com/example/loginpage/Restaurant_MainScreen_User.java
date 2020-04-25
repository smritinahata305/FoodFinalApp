package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class Restaurant_MainScreen_User extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private CardView res1, res2, res3;


    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant_main_screen);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //defining cards
        res1 = findViewById(R.id.rest1_card);
        res2 = findViewById(R.id.rest2_card);
        res3 = findViewById(R.id.rest3_card);


        //Add click listner to cards
        res1.setOnClickListener(this);
        res2.setOnClickListener(this);
        res3.setOnClickListener(this);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        //burger button

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //to make menu clickable
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        //select home menu as default
        navigationView.setCheckedItem(R.id.nav_home);

    }

    //backpress

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.rest1_card:
                PassDataR1();
                break;
            case R.id.rest2_card:
               // i = new Intent(this, Restaurant2.class);
                //startActivity(i);
                break;
            case R.id.rest3_card:
               // i = new Intent(this, Restaurant3.class);
               // startActivity(i);
                break;

            default:
                break;
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                navigationView.setCheckedItem(R.id.nav_home);
                break;

            case R.id.nav_cart:
                navigationView.setCheckedItem(R.id.nav_cart);
                PassData2();
                break;

            case R.id.nav_settings:
                navigationView.setCheckedItem(R.id.nav_settings);
                PassData3();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void PassDataR1() {

        String user_username = getIntent().getStringExtra("username");
        String user_name = getIntent().getStringExtra("name");
        String user_radius = getIntent().getStringExtra("radius");
        String user_phoneNo = getIntent().getStringExtra("phone");
        String user_password = getIntent().getStringExtra("password");

        Intent intent_set = new Intent(Restaurant_MainScreen_User.this, Restaurant1.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }

     private void PassData1() {

        String user_username = getIntent().getStringExtra("username");
        String user_name = getIntent().getStringExtra("name");
        String user_radius = getIntent().getStringExtra("radius");
        String user_phoneNo = getIntent().getStringExtra("phone");
        String user_password = getIntent().getStringExtra("password");

        Intent intent_set = new Intent(Restaurant_MainScreen_User.this, Settings_Cus.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }

    private void PassData2() {

        String user_username = getIntent().getStringExtra("username");
        String user_name = getIntent().getStringExtra("name");
        String user_radius = getIntent().getStringExtra("radius");
        String user_phoneNo = getIntent().getStringExtra("phone");
        String user_password = getIntent().getStringExtra("password");

        Intent intent_set = new Intent(Restaurant_MainScreen_User.this, Cart_User.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }

    private void PassData3() {

        String user_username = getIntent().getStringExtra("username");
        String user_name = getIntent().getStringExtra("name");
        String user_radius = getIntent().getStringExtra("radius");
        String user_phoneNo = getIntent().getStringExtra("phone");
        String user_password = getIntent().getStringExtra("password");

        Intent intent_set = new Intent(Restaurant_MainScreen_User.this, Settings_Cus.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }

    private void PassData4() {

        String user_username = getIntent().getStringExtra("username");
        String user_name = getIntent().getStringExtra("name");
        String user_radius = getIntent().getStringExtra("radius");
        String user_phoneNo = getIntent().getStringExtra("phone");
        String user_password = getIntent().getStringExtra("password");

        Intent intent_set = new Intent(Restaurant_MainScreen_User.this, CurrentOrder.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivityForResult(intent_set,1);
    }


}

