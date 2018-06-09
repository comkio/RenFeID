package com.example.emma.lab3;

/*
* Classe AsyncTask, llegeix de forma paral·lela els tags fent peticions http al servidor on esta llegeix el lector RFID.
* Objectiu: Quan el tag llegit sigui igual al UserID amb la sessió iniciada, iniciar viatge.
*
* */

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyTaskOrigin extends AsyncTask {
    String originIP;
    List<String> rfidList = new LinkedList<>();

    public MyTaskOrigin(String originIP) {
        this.originIP = originIP;
    }

    protected Object doInBackground(Object[] o) {
        String stringUrl = "http://"+originIP+":3161/devices";
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new URL(stringUrl).openStream());
            NodeList nodeList = doc.getElementsByTagName("id"); //id = simulator

            String id = nodeList.item(0).getTextContent();

            String urlstart = stringUrl+"/"+id+"/start";
            Document docstart = db.parse(new URL(urlstart).openStream());

            String url = stringUrl+"/"+id+"/inventory";

            Document doc2 = db.parse(new URL(url).openStream());
            NodeList nodeList2 = doc2.getElementsByTagName("status");
            String status = nodeList2.item(0).getTextContent();

            if(status.equals("OK")) { //simulator started
                Log.d("MyTaskOrig", "simulador emma started");
                String url2 = url+"/data/inventory/items/item/data/"; //accedeix a la url on esta emmagatzemat el xml que volem llegir
                Document doc3 = db.parse(new URL(url2).openStream()); //parseja el xml d'interes
                NodeList nodeList3 = doc3.getElementsByTagName("hexepc"); //busca el parametre que ens interessa
                if(nodeList3.getLength() != 0) {
                    rfidList.add(nodeList3.item(0).getTextContent());
                    Log.d("MyTaskOrig", "Llegint Tag: "+ nodeList3.item(0).getTextContent());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return rfidList;
    }

    @Override
    protected void onPostExecute(Object o) {
        if(rfidList.size() != 0) {
            
            //Cal comparar si el tag llegit coincideix amb el user ID que tingui la sessió iniciada.
            //if(MainActivity.db.myDao().getUserLogged() == rfidList.get(0)) llavors guardem el viatge
            if(MainActivity.db.myDao().getUserLogged() == Integer.parseInt(rfidList.get(0))) {
                Log.d("MyTaskOrig", rfidList.get(0));
                MainActivity.db.myDao().insertTravels(new Travel(0, originIP, "", true, 0,
                        Integer.parseInt(rfidList.get(0)))); //userId = rfid tag read
                Log.d("MyTaskOrig", "post-travel");
            }

        }

        /*int numUsers = MainActivity.db.myDao().numUsers();


        if (MainActivity.db.myDao().numStops() > 0) {
            Log.i("MyTaskOrigin:", "rfid read:" + MainActivity.db.myDao().getAllStops().get(0).getName());
        }*/
    }
}