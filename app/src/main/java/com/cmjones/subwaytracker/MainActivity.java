package com.cmjones.subwaytracker;

import com.cmjones.subwaytracker.lib.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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

    /** Arriving trains to populate the RecyclerView with. */
    List<Train> arrivals = new LinkedList<>();

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
                makeRequest();
            }
        });

        currentStation = findViewById(R.id.currentStation);
        recyclerView = findViewById(R.id.trains);

        // Layout size does not change with content changes
        recyclerView.setHasFixedSize(true);

        // Use linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(this, arrivals);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // set up the RecyclerView
        // adapter.setClickListener(this);
    }

    public void makeRequest() {
        String url = "http://datamine.mta.info/mta_esi.php?key=" + BuildConfig.API_KEY + "&feed_id=1";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        arrivals.clear();
                        arrivals.add(new Train(Service.A, "Brooklyn-Bound", "To Far Rockaway", false));
                        arrivals.add(new Train(Service.N, "Queens-Bound", "To Steinway St", true));
                        arrivals.add(new Train(Service.SEVEN, "Queens-Bound", "To Flushing - Main " +
                                "St", false));
                        arrivals.add(new Train(Service.A, "Manhattan-Bound", "To Inwood - 204 St",
                                true));
                        arrivals.add(new Train(Service.FIVE, "Manhattan-Bound", "To City Hall",
                                false));
                        arrivals.add(new Train(Service.SEVEN, "Queens-Bound", "To Flushing - Main " +
                                "St", false));
                        arrivals.add(new Train(Service.A, "Brooklyn-Bound", "To Far Rockaway", false));
                        arrivals.add(new Train(Service.N, "Queens-Bound", "To Steinway St", true));
                        currentStation.setText("Success!");
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                currentStation.setText("That didn't work!");
                adapter.notifyDataSetChanged();
            }
        });
        requestQueue.add(stringRequest);
    }
}
