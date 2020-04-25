package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.material.textfield.TextInputLayout;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {


    private Button register;
    private Button login;
    private TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login_button);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password_loginin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(v);
            }
        });


    }

    private void loginUser(View view) {

        if (!validateUsername() | !validatePassword()) {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        } else {
            isUser();
        }

    }

    private void isUser() {
        final String userEnteredUsername = username.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();
        //final String  = password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)) {
                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String categoryFromDB = dataSnapshot.child(userEnteredUsername).child("category").getValue(String.class);
                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phone").getValue(String.class);
                        String radiusFromDB = dataSnapshot.child(userEnteredUsername).child("radius").getValue(String.class);

                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                        // Here instead of deliveryPanel change it to required restaurant class.

                        if (categoryFromDB.equals("Foodie")) {
                            Intent intent = new Intent(getApplicationContext(), Restaurant_MainScreen_User.class);//***
                            intent.putExtra("username", userEnteredUsername);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("phone", phoneNoFromDB);
                            intent.putExtra("password", passwordFromDB);
                            startActivity(intent);
                            finish();//***
                        }

                        else {
                            Intent intent = new Intent(getApplicationContext(), DeliveryPanel.class);
                            intent.putExtra("radius", radiusFromDB);
                            intent.putExtra("username", userEnteredUsername);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("phone", phoneNoFromDB);
                            intent.putExtra("password", passwordFromDB);
                            startActivity(intent);
                            finish();//***

                        }


                    } else {

                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else {
                    username.setError("No such User exist");
                    username.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

}
