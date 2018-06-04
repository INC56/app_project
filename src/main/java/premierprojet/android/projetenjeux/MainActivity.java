package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button b1;
    EditText ed1, ed2;

    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.okbutton);
        ed1 = (EditText) findViewById(R.id.pseudo);
        ed2 = (EditText) findViewById(R.id.password);

        tx1 = (TextView) findViewById(R.id.linkregister);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("root")) {
                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Wrong password or pseudo!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, register.class);
                startActivity(intento);

            }
        });
    }
}

