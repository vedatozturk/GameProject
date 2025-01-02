package com.example.oyunlar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class sayfa_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sayfa1);

        ImageView imageView = findViewById(R.id.imageView2);
        Animation animation = AnimationUtils.loadAnimation(sayfa_1.this, R.anim.anim1);
        imageView.startAnimation(animation);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                    Network activeNetwork = cm.getActiveNetwork();
                    NetworkCapabilities capabilities = cm.getNetworkCapabilities(activeNetwork);

                    if (capabilities != null &&
                            (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))) {

                        Intent intent = new Intent(sayfa_1.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        AlertDialog.Builder adb = new AlertDialog.Builder(sayfa_1.this);
                        adb.setTitle("Hata");
                        adb.setMessage("İnternet Yok");
                        adb.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        adb.show();
                    }
                }
            }
        }, 5000);
    }


}