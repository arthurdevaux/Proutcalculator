package com.example.devauxarthur.proutcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private String temp_key, lat, lon, smell;
    private DatabaseReference rootCoords = FirebaseDatabase.getInstance().getReference().child("coordonnées");
    private DatabaseReference rootCoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText latitude = (EditText) findViewById(R.id.latitude);
        final EditText longitude = (EditText) findViewById(R.id.longitude);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.puanteur);
        Button envoie = (Button) findViewById(R.id.envoie);
        final TextView latitudeResult = (TextView)findViewById(R.id.latitudeResult);
        final TextView longitudeResult = (TextView)findViewById(R.id.longitudeResult);
        final TextView puanteurResult = (TextView)findViewById(R.id.puanteurResult);
        final TextView seekResult = (TextView) findViewById(R.id.seekResult);

        envoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                latitude.getText().toString();
                longitude.getText().toString();
                seekBar.getProgress();
                latitudeResult.setText(latitude.getText());
                longitudeResult.setText(longitude.getText());
                seekResult.getText().toString();

                Map<String, Object> map = new HashMap<String, Object>();
                temp_key = rootCoords.push().getKey().toString();
                rootCoords.updateChildren(map);

                Coordonnées mesCoords = new Coordonnées(lat, lon, smell);
                rootCoord = rootCoords.child(temp_key);
                rootCoord.setValue(mesCoords);

            }
        });

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekResult.setText(String.valueOf(progress));

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


    };
}



