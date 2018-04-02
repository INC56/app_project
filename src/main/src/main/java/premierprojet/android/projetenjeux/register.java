package premierprojet.android.projetenjeux;

/**
 * Created by Prosper Abega on 04/02/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class register extends AppCompatActivity {

    EditText ed1,ed2,ed3 ;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

       TextView tx1= (TextView) findViewById(R.id.linksign);
        b1 = (Button)findViewById(R.id.registerbbutton);
        ed1 = (EditText)findViewById(R.id.pseudo2);
        ed2 = (EditText)findViewById(R.id.password2);
        ed3 =(EditText)findViewById(R.id.confirmpassword);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ed1.getText().toString().length()==0) || (ed2.getText().toString().length()==0) || (ed3.getText().toString().length()==0 )){
                    Context context = getApplicationContext();
                    CharSequence text = "At least one term missing";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();}
                else if(!(ed2.getText().toString().equals(ed3.getText().toString()))){
                    Context context = getApplicationContext();
                    CharSequence text = "Password not checked";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }else{Intent intent = new Intent(register.this, home.class);
                    startActivity(intent);}

            }
        });


        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(register.this, MainActivity.class);
                startActivity(intento);

            }
        });










    }
}
