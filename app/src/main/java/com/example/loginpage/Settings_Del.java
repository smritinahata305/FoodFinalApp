package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Settings_Del extends AppCompatActivity {

    TextInputLayout fullName,username;
    TextInputLayout phoneNo,password,radius;
    TextView fullNameLabel,usernameLabel;
    DatabaseReference reference;
    String user_username, user_name,  user_radius ,user_phoneNo, user_password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings__del);


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
        radius.getEditText().setText(user_radius);
        phoneNo.getEditText().setText(user_phoneNo);
        password.getEditText().setText(user_password);
        username.getEditText().setText(user_username);

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

        }

    }

}
