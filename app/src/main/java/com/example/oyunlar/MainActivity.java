package com.example.oyunlar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    OyunAdapter oyunAdapter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        ArrayList<Oyunlar> oyunlar = new ArrayList<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Oyunlar");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot oyunSnapshot : snapshot.getChildren()) {
                    String oyunAd = oyunSnapshot.child("oyunAd").getValue(String.class);
                    String oyunYil = oyunSnapshot.child("oyunYil").getValue(String.class);
                    String oyunBoyut = oyunSnapshot.child("oyunBoyut").getValue(String.class);
                    String oyunTur = oyunSnapshot.child("oyunTur").getValue(String.class);
                    String oyunResim = oyunSnapshot.child("oyunResim").getValue(String.class);
                    String oyunUrl = oyunSnapshot.child("oyunUrl").getValue(String.class);
                    String oyunAciklama = oyunSnapshot.child("oyunAciklama").getValue(String.class);
                    Oyunlar oyun = new Oyunlar(oyunAd, oyunYil, oyunBoyut, oyunTur, oyunResim, oyunUrl, oyunAciklama);

                    oyunlar.add(oyun);
                }
                oyunAdapter = new OyunAdapter(MainActivity.this, oyunlar);
                listView.setAdapter(oyunAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseData", "Hata: " + error.getMessage());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Oyunlar tıklananOyun = oyunlar.get(i);
                Intent  git = new Intent(MainActivity.this,sayfa_3.class);
                git.putExtra("oyunUrl",tıklananOyun.getOyunUrl());
                git.putExtra("oyunAciklama",tıklananOyun.getOyunAciklama());
                startActivity(git);
            }
        });
    }
}