package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Prosper Abega on 04/02/2018.
 */

public class home extends Activity {

    ImageButton b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        b1 = findViewById(R.id.mesBeamy);
        b2 = findViewById(R.id.music);
        b3 = findViewById(R.id.projection);
        b4 = findViewById(R.id.réveil);



        /**
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(home.this, mesbeamy.class);
                    startActivity(intent);}});

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, music.class);
                startActivity(intent);}});

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, projection.class);
                startActivity(intent);}}); */

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Alarm.class);
                startActivity(intent);}});


    }
}
