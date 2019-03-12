package com.aditya.listview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class IntentActivity extends AppCompatActivity {

    CardView btnWeb, btnPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnWeb = findViewById(R.id.web);
        btnPlaylist=findViewById(R.id.playlist);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                startActivity(web);
            }
        });
        btnPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(IntentActivity.this, MainActivity.class);
                startActivity(pindah);
            }
        });
    }
}
