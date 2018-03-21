package premierprojet.android.projetenjeux;

import android.app.Activity;

/**
 * Created by theob on 19/02/2018.
 */

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class Alarm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

            Button b1,b2;

                b1 = findViewById(R.id.Add);
                b2 = findViewById(R.id.Modify);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alarm.this, Add_alarm.class);
                startActivity(intent);}});

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alarm.this, Modify_alarm.class);
                startActivity(intent);}});

    }
}
