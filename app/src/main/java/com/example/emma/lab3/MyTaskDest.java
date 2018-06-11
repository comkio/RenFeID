package com.example.emma.lab3;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyTaskDest extends AsyncTask {
    String destIP;

    public MyTaskDest(String destIP) {
        this.destIP = destIP;
    }

    protected Object doInBackground(Object[] o) {
        String stringUrl = "http://"+destIP+":3161/devices";
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

            //Segons l'antena que retorni l'iventory, sera una estacio de tren una altra
            String rfid = "";
            if(status.equals("OK")) { //simulator started
                String url2 = url+"/data/inventory/items/item/data/";
                Document doc3 = db.parse(new URL(url2).openStream());
                NodeList nodeList3 = doc3.getElementsByTagName("hexepc");
                if(nodeList3.getLength() != 0) {
                    rfid = nodeList3.item(0).getTextContent(); //tag que llegeix a l'estacio desti
                    Log.d("MyTaskDest:", "llegint tag: "+rfid);
                    int travelInitiated = MainActivity.db.myDao().getTravelInitiated();
                    Travel travel = new Travel();
                    if(travelInitiated != 0) {
                        travel = MainActivity.db.myDao().getAllTravels().get(0);
                    }
                    if (Integer.parseInt(rfid) == travel.userId){
                        Log.d("mytaskdest","TRAVEL FINISHED!");
                        MainActivity.db.myDao().updateStatusTravel(false,travel.getId());
                        MainActivity.db.myDao().updateCostTravel(3,travel.getId());
                        MainActivity.db.myDao().updateIdToTravel(destIP,travel.getId());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
    }
}