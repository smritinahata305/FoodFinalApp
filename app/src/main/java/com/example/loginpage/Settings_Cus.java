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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Settings_Cus extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    TextInputLayout fullName,username;
    TextInputLayout phoneNo,password,radius;
    TextView fullNameLabel,usernameLabel;
    DatabaseReference reference;
    String user_username, user_name,  user_radius ,user_phoneNo, user_password ;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings__cus);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //to make menu clickable
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        //select home menu as default
        navigationView.setCheckedItem(R.id.nav_settings);



        reference = FirebaseDatabase.getInstance().getReference("users");
        fullNameLabel = findViewById(R.id.fullName_field);
        usernameLabel = findViewById(R.id.username_field);
        fullName = findViewById(R.id.fullName);
        username = findViewById(R.id.username);
        radius = findViewById(R.id.radius);
        phoneNo = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        Intent intent = getIntent();
        user_username = intent.getStringExtra("username");
        user_name = intent.getStringExtra("name");
        user_radius = intent.getStringExtra("radius");
        user_phoneNo = intent.getStringExtra("phone");
        user_password = intent.getStringExtra("password");

        fullNameLabel.setText(user_name);
        usernameLabel.setText(user_username);
        fullName.getEditText().setText(user_name);

        phoneNo.getEditText().setText(user_phoneNo);
        password.getEditText().setText(user_password);
        username.getEditText().setText(user_username);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    public void Update(View view)
    {
        fullName = findViewById(R.id.fullName);
        username = findViewById(R.id.username);
        radius = findViewById(R.id.radius);
        phoneNo = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        if(fullName.getEditText().getText().toString().equals(user_name) && password.getEditText().getText().toString().equals(user_password)
        && phoneNo.getEditText().getText().toString().equals(user_phoneNo) && radius.getEditText().getText().toString().equals(user_radius))
        {
            Toast.makeText(this, "No value to update!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            reference.child(user_username).child("password").setValue(password.getEditText().getText().toString());
            user_password=password.getEditText().getText().toString();

            reference.child(user_username).child("phone").setValue(phoneNo.getEditText().getText().toString());
            user_phoneNo=phoneNo.getEditText().getText().toString();

            reference.child(user_username).child("radius").setValue(radius.getEditText().getText().toString());
            user_radius=radius.getEditText().getText().toString();

            reference.child(user_username).child("name").setValue(fullName.getEditText().getText().toString());
            user_name=fullName.getEditText().getText().toString();

            Toast.makeText(this, "Updated Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings_Cus.this,Restaurant_MainScreen_User.class);
            navigationView.setCheckedItem(R.id.nav_home);
            startActivity(intent);

        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                navigationView.setCheckedItem(R.id.nav_home);
                PassData1();
                break;

            case R.id.nav_cart:
                navigationView.setCheckedItem(R.id.nav_cart);
                PassData2();
                break;

            case R.id.nav_settings:

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

        Intent intent_set = new Intent(Settings_Cus.this, Restaurant_MainScreen_User.class);
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

        Intent intent_set = new Intent(Settings_Cus.this, Cart_User.class);
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

        Intent intent_set = new Intent(Settings_Cus.this, Settings_Cus.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivity(intent_set);
    }



}
