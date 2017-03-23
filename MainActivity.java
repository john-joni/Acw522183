package com.example.jonni.acw522183;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MyWebServiceListener {

    private RecyclerView recyclerView;
    private ArrayList<Puzzle> data;
    private DataAdapter adapter;
    VolleyClient volleyClient;
    ArrayList <Puzzle> puzzlesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


         volleyClient = new VolleyClient(this);
         volleyClient.getRequest("http://www.hull.ac.uk/php/349628/08027/acw/index.json", this);
    }

    public void onRequestComplete(Boolean jsonStatus)
    {

        String myResponse =  volleyClient.myResponse;


        JsonHandler jsonHandler = new JsonHandler(myResponse);
        HashMap<String, String> hashMap = jsonHandler.jsonToHashmap();

        myResponse = hashMap.get("PuzzleIndex");

        jsonHandler = new JsonHandler(myResponse);

        puzzlesArrayList = new ArrayList<Puzzle>();

        ArrayList<String> arrayList = jsonHandler.jsontoArraylistOfStrings();

        for(int i = 0; i < arrayList.size(); i++)
        {
            Puzzle puzzle = new Puzzle(arrayList.get(i));

            puzzlesArrayList.add(puzzle);

        }

        adapter = new DataAdapter(puzzlesArrayList);
        recyclerView.setAdapter(adapter);
        boolean test = jsonStatus;

    }
}
