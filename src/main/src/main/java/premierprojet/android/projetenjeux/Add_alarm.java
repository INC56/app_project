package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by theob on 06/03/2018.
 */

public class Add_alarm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alarm);

        Button b1,b2,b3;

        b1 = findViewById(R.id.recurring);
        b2 = findViewById(R.id.Music);
        b3 = findViewById(R.id.complete);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_alarm.this, Recurring.class);
                startActivity(intent);}});


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_alarm.this.finish(); }});
    }
}