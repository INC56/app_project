package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class chronometer extends Activity implements View.OnClickListener {

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
        Intent intent = getIntent();
        String url = intent.getStringExtra("http://inc56.cs-campus.fr:8000/api/auth/?username=solo&password=qwerty123456789&imei=1234'");
        new FetchTask().execute(url);
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private class FetchTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            snackbar.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            InputStream inputStream = null;
            HttpURLConnection conn = null;

            String stringUrl = strings[0];
            try {
                URL url = new URL(stringUrl);
                conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                int response = conn.getResponseCode();
                if (response != 200) {
                    return null;
                }

                inputStream = conn.getInputStream();
                if (inputStream == null) {
                    return null;
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuffer buffer = new StringBuffer();
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                    buffer.append("\n");
                }

                return new String(buffer);
            } catch (IOException e) {
                return null;
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s == null) {
                resultsTextView.setText("Erreur");
                Context context = getApplicationContext();
                CharSequence text = "Wrong password or pseudo or imei!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } else {
                xml=s;
                token=getToken();
                Intent intent = new Intent(chronometer.this, home.class);
                intent.putExtra("token",token);
                startActivity(intent);
            }
            snackbar.dismiss();
        }

        //private String xml = "<?xml version=\"1.0\"?>\n"+
        //        "<set>\n"+
        //        "  <user>\n"+
        //        "    <username>solo</username>\n"+
        //        "    <firstname>han</firstname>\n"+
        //        "    <lastname>solo</lastname>\n"+
        //        "    <email>han.solo@sw.com</email>\n"+
        //        "    <token>bd73be60-49dd-4518-95bd-4841259cd33a</token>\n"+
        //        "  </user>\n"+
        //        "</set>"; // REMPLACER PAR LE RETOUR DE LA REQUETE GET



        public String getToken()
        {

            String requestedToken = null;

            try
            {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
                doc.getDocumentElement().normalize(); // DOM parsing

                NodeList nList = doc.getElementsByTagName("user");
                Node nNode = nList.item(0);
                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element)nNode;
                    requestedToken = eElement.getElementsByTagName("token").item(0).getTextContent();
                    //System.out.println("Token du cul : " + requestedToken);
                }

            } catch (Exception e) { e.printStackTrace(); }

            //resultsTextView.setText(requestedToken);
            return(requestedToken);

        }

    }
}