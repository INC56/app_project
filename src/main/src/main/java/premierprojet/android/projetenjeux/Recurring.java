package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by theob on 06/03/2018.
 */

public class Recurring extends Activity{

    Button b1;
    Switch monday,tuesday,wednesday,thursday,friday,saturday,sunday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recurring);


        b1 = findViewById(R.id.Complete);
        monday = findViewById(R.id.switch_monday);
        tuesday = findViewById(R.id.switch_tuesday);
        wednesday = findViewById(R.id.switch_wednesday);
        thursday = findViewById(R.id.switch_thursday);
        friday = findViewById(R.id.switch_friday);
        saturday = findViewById(R.id.switch_saturday);
        sunday = findViewById(R.id.switch_sunday);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recurring.this.finish(); }});



    }
}
