package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Restaurant1 extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Button button_cart;
    EditText t1,t2;
    String menu1="Salad";
    String menu2="Biryani";
    String rest = "Rajendra Dhabha";
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //to make menu clickable
        navigationView =findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        //select home menu as default
        navigationView.setCheckedItem(R.id.nav_home);

        drawerLayout =findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //passing data
        t1=findViewById(R.id.editText);
        t2=findViewById(R.id.editText2);



        //Go to cart button
        button_cart=findViewById(R.id.button_toCart);
        button_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //pushing user data
                String user_username = getIntent().getStringExtra("username");
                String user_name = getIntent().getStringExtra("name");
                String user_radius = getIntent().getStringExtra("radius");
                String user_phoneNo = getIntent().getStringExtra("phone");
                String user_password = getIntent().getStringExtra("password");

                Intent intent_set =new Intent(Restaurant1.this, Cart_User.class);
                intent_set.putExtra("username", user_username);
                intent_set.putExtra("name", user_name);
                intent_set.putExtra("radius", user_radius);
                intent_set.putExtra("phone", user_phoneNo);
                intent_set.putExtra("password", user_password);

                String getvalue1 = t1.getText().toString();
                String getvalue2 =t2.getText().toString();

                if(!getvalue1.equals("") || !getvalue2.equals("")) {

                    intent_set.putExtra("REST",rest);

                    if (!getvalue1.equals("")) {
                        intent_set.putExtra("MENU1", menu1);
                        intent_set.putExtra("QUANTITY1", getvalue1);
                    }

                    if (!getvalue2.equals("")) {
                        intent_set.putExtra("MENU2", menu2);
                        intent_set.putExtra("QUANTITY2", getvalue2);
                    }
                    startActivityForResult(intent_set, 1);
                }
                else
                    Toast.makeText(Restaurant1.this,"Nothing is selected",Toast.LENGTH_SHORT).show();
            }


        });

    }

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

        Intent intent_set = new Intent(Restaurant1.this, Restaurant_MainScreen_User.class);
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

        Intent intent_set = new Intent(Restaurant1.this, Cart_User.class);
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

        Intent intent_set = new Intent(Restaurant1.this, Settings_Cus.class);
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

        Intent intent_set = new Intent(Restaurant1.this, CurrentOrder.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }


}


