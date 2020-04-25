package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Available_Order extends AppCompatActivity {

    final int SMS_PERMISSION_CODE = 1;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available__order);

        listview = findViewById(R.id.listView);
        ArrayList<String>  list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_available__order,R.id.listText,list);
        listview.setAdapter(adapter);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Order");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for(DataSnapshot snap : dataSnapshot.getChildren()) {
                    AvailableOrderHelper order = snap.getValue(AvailableOrderHelper.class);
                    list.add("Restaurant Name  :  "+order.getName_restaurant().toString()+"\nCustomer Name  :  "+order.getName_customer().toString()+"\nAmount  :  "+order.getAmount().toString()
                            +"\nPhone Number  :  "+order.getPhone_no());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = list.get(position);
                String number = item.substring(item.length()-10);
                Toast.makeText(Available_Order.this, "Order Number "+position+1+" in process now.", Toast.LENGTH_SHORT).show();
                if(checkPermission(Manifest.permission.SEND_SMS))
                {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,"Hi I am your delivery help! I will be reaching you shortly",null,null);
                }
                else
                {
                    ActivityCompat.requestPermissions(Available_Order.this,new String[]{Manifest.permission.SEND_SMS},SMS_PERMISSION_CODE);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,"Hi I am your delivery help! I will be reaching you shortly",null,null);
                }


            }
        });

    }
    public boolean checkPermission(String permission)
    {
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check== PackageManager.PERMISSION_GRANTED);
    }


}
