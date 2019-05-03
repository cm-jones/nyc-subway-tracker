package com.cmjones.subwaytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

/**
 * The application's main activity.
 */
public class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "nyc-subway-tracker:Main";

    /** Request queue for network requests. */
    private RequestQueue requestQueue;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button makeRequest;

    /**
     * Run when the main activity comes into view.
     *
     * @param savedInstanceState state saved on the last pause
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestQueue = Volley.newRequestQueue(this);

        super.onCreate(savedInstanceState);

        // Load the main layout
        setContentView(R.layout.activity_main);

        /*
         * Set up button handlers.
         */
        makeRequest = findViewById(R.id.makeRequest);
        makeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Make request button clicked");
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        // Layout size does not change with content changes
        recyclerView.setHasFixedSize(true);

        // Use linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        adapter = new MyAdapter(this, animalNames);
        recyclerView.setAdapter(adapter);

        // set up the RecyclerView
        // adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}
