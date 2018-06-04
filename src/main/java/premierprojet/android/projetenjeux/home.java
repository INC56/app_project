package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(home.this, Mesbeamys.class);
                    startActivity(intent);}});

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, testrequete2.class);
                startActivity(intent);}});

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, chronometer.class);
                startActivity(intent);}});

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Alarm.class);
                startActivity(intent);}});


    }
}
