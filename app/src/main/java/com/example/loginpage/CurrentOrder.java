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
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CurrentOrder extends AppCompatActivity implements   NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    NavigationView navigationView;


    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //to make menu clickable
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        //select cart menu as default
        navigationView.setCheckedItem(R.id.nav_cart);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //putting data
        t5=findViewById(R.id.textView_rest_name);
        t1=findViewById(R.id.textView_item1);
        t2=findViewById(R.id.textView_quantity1);
        t3=findViewById(R.id.textView_item2);
        t4=findViewById(R.id.textView_quantity2);


        t5.setText(getIntent().getStringExtra("REST"));


        t1.setText(getIntent().getStringExtra("MENU1"));
        t2.setText(getIntent().getStringExtra("QUANTITY1"));


        t3.setText(getIntent().getStringExtra("MENU2"));
        t4.setText(getIntent().getStringExtra("QUANTITY2"));



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                PassData1();
                navigationView.setCheckedItem(R.id.nav_home);
                break;



            case R.id.nav_cart:
                PassData2();
                navigationView.setCheckedItem(R.id.nav_cart);
                break;

            case R.id.nav_settings:

                PassData3();
                navigationView.setCheckedItem(R.id.nav_settings);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void PassData1() {

        String user_username = getIntent().getStringExtra("username");
        String user_name = getIntent().getStringExtra("name");
        String user_radius = getIntent().getStringExtra("radius");
        String user_phoneNo = getIntent().getStringExtra("phone");
        String user_password = getIntent().getStringExtra("password");

        Intent intent_set = new Intent(CurrentOrder.this, Restaurant_MainScreen_User.class);
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

        Intent intent_set = new Intent(CurrentOrder.this, Cart_User.class);
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

        Intent intent_set = new Intent(CurrentOrder.this, Settings_Cus.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }
}
