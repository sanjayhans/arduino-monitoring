package com.panic1k.housemonitoring;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  DatabaseReference dref;
  TextView text_temperature, text_humidity, text_airquality, text_soilmoisture;
  String temp, hum, air, soilmoisture;
  int col1 = Color.parseColor("#b32d00"), col2 = Color.parseColor("#000000");


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FirebaseApp.initializeApp(this);
    setContentView(R.layout.activity_main);

    text_temperature = findViewById(R.id.textTemp);
    text_airquality = findViewById(R.id.textAir);
    text_humidity = findViewById(R.id.textHum);
    text_soilmoisture = findViewById(R.id.textSoil);

    dref = FirebaseDatabase.getInstance().getReference();
    dref.addValueEventListener(new ValueEventListener() {

      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        temp = Objects.requireNonNull(Objects.requireNonNull(dataSnapshot).child("t").getValue()).toString();
        Log.e("***", "onDataChange -> " + temp);
        text_temperature.setText(String.format("%sC", temp));
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });


    dref = FirebaseDatabase.getInstance().getReference();
    dref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        hum = Objects.requireNonNull(dataSnapshot.child("h").getValue()).toString();
        text_humidity.setText(String.format("%s%%", hum));

      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });

    dref = FirebaseDatabase.getInstance().getReference();
    dref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        air = Objects.requireNonNull(dataSnapshot.child("airData").getValue()).toString();
        text_airquality.setText(air);

      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });

    dref = FirebaseDatabase.getInstance().getReference();
    dref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        soilmoisture = Objects.requireNonNull(dataSnapshot.child("soilData").getValue()).toString();
        int soilData = Integer.parseInt(soilmoisture);


        if (soilData == 0) {

          text_soilmoisture.setText(R.string.no_water);
          text_soilmoisture.setTextColor(col2);

        } else {
          text_soilmoisture.setText(R.string.required_water);
          text_soilmoisture.setTextColor(col1);
        }

      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
  }
}
