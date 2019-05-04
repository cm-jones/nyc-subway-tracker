package com.cmjones.subwaytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
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

import java.util.LinkedList;
import java.util.List;

/**
 * The application's main activity.
 */
public class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "nyc-subway-tracker:main";

    /** Request queue for network requests. */
    private RequestQueue requestQueue;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    private Button makeRequest;
    private TextView currentStation;

    /**
     * Executes when the main activity loads.
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
                currentStation.setText("Times Square-42nd Street");
            }
        });

        currentStation = findViewById(R.id.currentStation);

        recyclerView = findViewById(R.id.trains);

        // Layout size does not change with content changes
        recyclerView.setHasFixedSize(true);

        // Use linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Data to populate the RecyclerView with
        List<String> arrivals = new LinkedList<>();
        arrivals.add("A");
        arrivals.add("5");
        arrivals.add("7");

        adapter = new MyAdapter(this, arrivals);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // set up the RecyclerView
        // adapter.setClickListener(this);
    }

}
