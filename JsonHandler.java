package com.example.jonni.acw522183;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class JsonHandler {
    private JSONArray jsonArray;
    private JSONObject jsonObject;
    String resultMessage;

    public JsonHandler(String jsonString)
    {
        try {
            if(jsonString.startsWith("[")) {
                jsonArray = new JSONArray(jsonString);
            }
            else
            {
                jsonObject = new JSONObject(jsonString);

            }

        }
        catch(JSONException e)
        {

        }

    }

       public HashMap<String,String> jsonToHashmap ()
    {
        HashMap<String, String> jsonHashMap = new HashMap<String, String>();
        if (jsonObject == null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject j = jsonArray.optJSONObject(i);
                Iterator it = j.keys();

                while (it.hasNext()) {
                    String k = it.next().toString();

                    try {
                        String v = j.getString(k);
                        jsonHashMap.put(k, v);


                    } catch (JSONException e) {

                    }
                }
            }
        }
        else
        {
            for(int i=0; i < jsonObject.length();i++)
            {
                Iterator it = jsonObject.keys();

                while (it.hasNext()) {
                    String k = it.next().toString();

                    try {
                        String v = jsonObject.getString(k);
                        jsonHashMap.put(k, v);
                    } catch (JSONException e) {
                    }
                }
            }
        }

        return jsonHashMap;
    }


    public ArrayList<String> jsontoArraylistOfStrings() {


        ArrayList<String> arraylist= new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {

            try {
                String element = (String) jsonArray.get(i);
                arraylist.add(element);
            }
            catch(JSONException e)
            {

            }
        }

        return arraylist;
    }

    public ArrayList<HashMap<String,String>> jsontoArraylistHashmap() {

        ArrayList<HashMap<String,String>> arraylist= new ArrayList<HashMap<String,String>>();
        for (int i = 0; i < jsonArray.length(); i++) {
            HashMap<String, String> jsonHashMap = new HashMap<String, String>();
            try {
                JSONObject j = jsonArray.getJSONObject(i);
                Iterator it = j.keys();
                while (it.hasNext()) {
                    String k = it.next().toString();

                    try {
                        String v = j.getString(k);
                        jsonHashMap.put(k, v);

                    } catch (JSONException e) {
                    }
                }
                arraylist.add(jsonHashMap);
            }
            catch (JSONException e) {
            }
        }
        return arraylist;
    }
}

