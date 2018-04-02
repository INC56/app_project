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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.



public class Alarm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

            ListView L;
            Button b1;
            String alarm_list;

        alarm_list = get("http://")
        L = findViewById(R.id.Alarm_list);
        b1 = findViewById(R.id.Add);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alarm.this, Add_alarm.class);
                startActivity(intent);}});





        /*

        String[] prenoms = new String[]{
                "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
                "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
                "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
                "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
                "Yann", "Zoé"
        };

        */


           /* final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, prenoms);
            mListView.setAdapter(adapter);  */



    }
}
