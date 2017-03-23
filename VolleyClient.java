package com.example.jonni.acw522183;


import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jonni.acw522183.MainActivity;
import com.example.jonni.acw522183.MyWebServiceListener;


public class VolleyClient {

    public String myResponse = "";

    MyWebServiceListener webServiceListener;

    public VolleyClient(MyWebServiceListener webServiceListener)
    {
        this.webServiceListener = webServiceListener;
    }

    public void getRequest(String url, Activity myActivity)
    {
           RequestQueue queue = Volley.newRequestQueue(myActivity);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        myResponse = response;

                        webServiceListener.onRequestComplete(true);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(" Test", "That didn't work!");

                myResponse = "That didn't work!";
                webServiceListener.onRequestComplete(false);
            }
        });

        queue.add(stringRequest);

    }

}

