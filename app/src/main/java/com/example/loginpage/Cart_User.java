package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cart_User extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Button btn_placeOrder;
    TextView t1,t2,t3,t4,t5,t6;
    int amount;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

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
        t5.setText(getIntent().getStringExtra("REST"));

        t1=findViewById(R.id.textView_item1);
        t2=findViewById(R.id.textView_quantity1);

        t1.setText(getIntent().getStringExtra("MENU1"));
        t2.setText(getIntent().getStringExtra("QUANTITY1"));

        t3=findViewById(R.id.textView_item2);
        t4=findViewById(R.id.textView_quantity2);

        t3.setText(getIntent().getStringExtra("MENU2"));
        t4.setText(getIntent().getStringExtra("QUANTITY2"));


        //total cost
        t6=findViewById(R.id.cart_totalamount);
        if(!t2.getText().toString().equals("") && !t4.getText().toString().equals("")) {
            amount = 100 * Integer.parseInt(t2.getText().toString()) + 200 * Integer.parseInt(t4.getText().toString());
        }
        else if(t4.getText().toString().equals("") && !t2.getText().toString().equals("")) {
            amount = 100 * Integer.parseInt(t2.getText().toString());
        }
        else if(t2.getText().toString().equals("") && !t4.getText().toString().equals("") )
            amount = 200 * Integer.parseInt(t4.getText().toString());

        t6.setText(String.valueOf(amount));

        btn_placeOrder=findViewById(R.id.button_placeorder);

        btn_placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder(v);
            }
        });

    }

    private void placeOrder(View view) {
        rootNode= FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Order");
        CartHelperClass helperClass = null;
        String user_name = getIntent().getStringExtra("name");
        String phone_no = getIntent().getStringExtra("phone");
        String rest_name = t5.getText().toString();
        String amount = t6.getText().toString();
        String dish1= t1.getText().toString();
        String dish2= t3.getText().toString();
        String  quantity1,quantity2;

        if(t4.getText().toString().equals("") ) {
            quantity1 = t2.getText().toString();
            quantity2 = "0";
        }
        else if(t2.getText().toString().equals("")){
            quantity1 = "0";
            quantity2 = t4.getText().toString();
        }
        else{
            quantity1 = t2.getText().toString();
            quantity2 = t4.getText().toString();
        }

        helperClass = new CartHelperClass(user_name,phone_no, rest_name, dish1, quantity1, dish2, quantity2,amount);
        reference.child(phone_no).setValue(helperClass);


        //pushing to current orders
      /*  Intent intent_set = new Intent(Cart_User.this, CurrentOrder.class);
        String res_n=t5.getText().toString();
        String q1 = t2.getText().toString();
        String q2 = t4.getText().toString();

        intent_set.putExtra("REST",res_n);
        intent_set.putExtra("MENU1", dish1);
        intent_set.putExtra("MENU2", dish2);
        intent_set.putExtra("QUANTITY1", q1);
        intent_set.putExtra("QUANTITY2", q2);
        startActivity(intent_set);*/




        Intent i = new Intent(Cart_User.this, Payment1.class);
        startActivity(i);

        Toast.makeText(this, "Select Payment Method", Toast.LENGTH_SHORT).show();
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
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                PassData1();
                navigationView.setCheckedItem(R.id.nav_home);
                break;

            case R.id.nav_cart:
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

        Intent intent_set = new Intent(Cart_User.this, Restaurant_MainScreen_User.class);
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

        Intent intent_set = new Intent(Cart_User.this, Cart_User.class);
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

        Intent intent_set = new Intent(Cart_User.this, Settings_Cus.class);
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

        Intent intent_set = new Intent(Cart_User.this, CurrentOrder.class);
        intent_set.putExtra("username", user_username);
        intent_set.putExtra("name", user_name);
        intent_set.putExtra("radius", user_radius);
        intent_set.putExtra("phone", user_phoneNo);
        intent_set.putExtra("password", user_password);
        startActivityForResult(intent_set, 1);
    }

}

