package com.aditya.listview;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    MediaPlayer mp;

    String[] namasurat = {
            "Surat An Nas",
            "Surat Al Falaq",
            "Surat Al Ikhlas"
    };
    int[] suarasurat={
      R.raw.annas,
      R.raw.alfalaq,
      R.raw.alikhlas
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview =  findViewById(R.id.list);
        mp = new MediaPlayer();

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, namasurat);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Anda Telah memilih"+namasurat[position], Toast.LENGTH_SHORT).show();
                playSound(position);
            }
        });

    }

    private void playSound(int position) {
        mp.reset();
        mp = MediaPlayer.create(MainActivity.this,suarasurat[position]);
        mp.start();
    }
}
