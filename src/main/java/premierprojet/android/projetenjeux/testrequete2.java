package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class testrequete2 extends Activity implements View.OnClickListener {

    private LinearLayout linearLayout;
    private Button requestButton;
    private TextView resultsTextView;
    private Snackbar snackbar;
    private String xml;
    public String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeView();
        setContentView(linearLayout);
        snackbar = Snackbar.make(linearLayout, "Requête en cours d'exécution",
                Snackbar.LENGTH_INDEFINITE);
    }

    // Le layout est généré programmatiquement pour simplifier l'article
    private void makeView() {
        requestButton = new Button(this);
        requestButton.setText("Lancer une requête");
        requestButton.setOnClickListener(this);

        resultsTextView = new TextView(this);

        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(requestButton);
        linearLayout.addView(resultsTextView);
    }

    @Override
    public void onClick(View view) {
        if (!isConnected()) {
            Snackbar.make(view, "Aucune connexion à internet.", Snackbar.LENGTH_LONG).show();
            return;
        }

    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}