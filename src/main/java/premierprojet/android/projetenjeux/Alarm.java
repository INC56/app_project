package premierprojet.android.projetenjeux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by theob on 19/02/2018.
 */



public class Alarm extends Activity {


    static String xml2 = "<?xml version=\"1.0\"?>\r\n" +
            "<set>\r\n" +
            "    <alarm>\r\n" +
            "        <name>Get up!</name>\r\n" +
            "        <alarm_id>1</alarm_id>\r\n" +
            "        <beamy_id>1</beamy_id>\r\n" +
            "        <time>\r\n" +
            "            <day>monday, tuesday</day>\r\n" +
            "            <hour>8</hour>\r\n" +
            "            <minute>3</minute>\r\n" +
            "        </time>\r\n" +
            "        <enabled>true</enabled>\r\n" +
            "        <running>false</running>\r\n" +
            "        <ringtone>/media/song/default_ringtone_1111111111-49c05df1-3829-4506-9bab-d54d21c77ac7.mp3</ringtone>\r\n" +
            "    </alarm>\r\n" +
            "    <alarm>\r\n" +
            "		 <name>Come on!</name>\r\n" +
            "        <alarm_id>2</alarm_id>\r\n" +
            "        <beamy_id>1</beamy_id>\r\n" +
            "        <time>\r\n" +
            "            <day>monday, tuesday</day>\r\n" +
            "            <hour>10</hour>\r\n" +
            "            <minute>40</minute>\r\n" +
            "        </time>\r\n" +
            "        <enabled>true</enabled>\r\n" +
            "        <running>false</running>\r\n" +
            "        <ringtone>/media/song/default_ringtone_1111111111-49c05df1-3829-4506-9bab-d54d21c77ac7.mp3</ringtone>\r\n" +
            "    </alarm>\r\n" +
            "</set>"; // REMPLACER PAR LE RETOUR DE LA REQUETE GET




    public static List<String> getAlarmNames()
    {

        List<String> alarmNames = new ArrayList<String>();

        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xml2)));
            doc.getDocumentElement().normalize(); // DOM parsing

            NodeList nList = doc.getElementsByTagName("alarm");

            for(int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element)nNode;
                    alarmNames.add(eElement.getElementsByTagName("name").item(0).getTextContent());
                }
            }
            //System.out.println(alarmNames);

			/*Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element)nNode;
				requestedToken = eElement.getElementsByTagName("token").item(0).getTextContent();
				//System.out.println("Token du cul : " + requestedToken);
			}*/

        } catch (Exception e) { e.printStackTrace(); }

        return(alarmNames);

    }

    public static List<Integer> getAlarmHours()
    {

        List<Integer> alarmHours = new ArrayList<Integer>();

        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xml2)));
            doc.getDocumentElement().normalize(); // DOM parsing

            NodeList nList = doc.getElementsByTagName("time");

            for(int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element)nNode;
                    String alarm = eElement.getElementsByTagName("hour").item(0).getTextContent();
                    int hour = Integer.parseInt(alarm);
                    alarmHours.add(hour);
                    //System.out.println(alarm);
                }
            }
            //System.out.println(alarmNames);

			/*Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element)nNode;
				requestedToken = eElement.getElementsByTagName("token").item(0).getTextContent();
				//System.out.println("Token du cul : " + requestedToken);
			}*/

        } catch (Exception e) { e.printStackTrace(); }

        return(alarmHours);

    }

    public static List<Integer> getAlarmMinutes()
    {

        List<Integer> alarmMinutes = new ArrayList<Integer>();

        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xml2)));
            doc.getDocumentElement().normalize(); // DOM parsing

            NodeList nList = doc.getElementsByTagName("time");

            for(int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element)nNode;
                    String alarm = eElement.getElementsByTagName("minute").item(0).getTextContent();
                    int minute = Integer.parseInt(alarm);
                    alarmMinutes.add(minute);
                    //System.out.println(alarm);
                }
            }
            //System.out.println(alarmNames);

			/*Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element)nNode;
				requestedToken = eElement.getElementsByTagName("token").item(0).getTextContent();
				//System.out.println("Token du cul : " + requestedToken);
			}*/

        } catch (Exception e) { e.printStackTrace(); }

        return(alarmMinutes);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

        ListView L;
        Button b1;
        List<String> Nom;
        List Heure, Minute;
        Integer n;

        /*    String alarm_list; */

        L = findViewById(R.id.Alarm_list);
        b1 = findViewById(R.id.Add);
        Nom = getAlarmNames();
        Heure = getAlarmHours();
        Minute = getAlarmMinutes();
        n = Nom.size();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alarm.this, Add_alarm.class);
                startActivity(intent);}});

        String[] prenoms = new String[n]{
        for (int i=0; i<n; i++) {
            prenoms[i]= bite;
        }
        };









        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Alarm.this,
                android.R.layout.simple_list_item_1, prenoms);
        L.setAdapter(adapter);



    }
}


