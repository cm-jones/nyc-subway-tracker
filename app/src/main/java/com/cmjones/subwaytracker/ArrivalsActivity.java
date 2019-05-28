package com.cmjones.subwaytracker;

import com.cmjones.subwaytracker.lib.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;
import java.util.LinkedList;

/**
 * The application's main activity.
 */
public class ArrivalsActivity extends AppCompatActivity {
    /** Default logging tag for messages from this activity */
    private static final String TAG = "ArrivalsActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    /** Request queue for network requests */
    private RequestQueue requestQueue;

    /** Arriving trains to populate the RecyclerView with. */
    private List<Train> arrivals = new LinkedList<>();

    /**
     * Executes when this activity loads
     *
     * @param savedInstanceState state saved on the last pause
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Get this activity's layout */
        setContentView(R.layout.activity_arrivals);

        /* Create a new request queue to handle API requests */
        requestQueue = Volley.newRequestQueue(this);

        /* Set up this activity's toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Arrivals");

        /* Set up a RecyclerView to list the train arrivals */
        recyclerView = findViewById(R.id.arrivals);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /* Draw a line separator between the trains in the RecyclerView */
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);

        /* Create an adapter to handle the data inside the RecyclerView */
        adapter = new ArrivalsListAdapter(this, arrivals);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                Log.d(TAG, "Refresh button pressed");
                /* Make a request to the MTA API */
                makeRequest(1);
                break;
            case R.id.action_menu:
                Log.d(TAG, "Menu button pressed");
                break;
            case R.id.action_settings:
                Log.d(TAG, "Settings button pressed");
                break;
        }
        return true;
    }

    /**
     * Make an API request to retrieve GTFS Realtime data
     * TODO: Convert the GTFS data to JSON; organize the feed IDs
     *
     * @param feedID the ID that identifies the set of trains we are interested in
     */
    private void makeRequest(final int feedID) {
        String url = "http://datamine.mta.info/mta_esi.php?key=" + BuildConfig.API_KEY +
                "&feed_id=" + feedID;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);

                        /* Purge the arrivals list to prepare it to receive new information*/
                        arrivals.clear();
                        
                        /* TODO: Populate the arrivals list with the API response */
                        arrivals.add(new Train(Service.A, "Brooklyn-bound", "to Far Rockaway",
                                false));
                        arrivals.add(new Train(Service.N, "Queens-bound", "to Steinway St", true));
                        arrivals.add(new Train(Service.SEVEN, "Queens-bound", "to Flushing - Main" +
                                " " +
                                "St", false));
                        arrivals.add(new Train(Service.A, "Manhattan-bound", "to Inwood - 204 St",
                                true));
                        arrivals.add(new Train(Service.FIVE, "Manhattan-bound", "to City Hall",
                                false));
                        arrivals.add(new Train(Service.SEVEN, "Queens-bound", "to Flushing - Main" +
                                " " +
                                "St", false));
                        arrivals.add(new Train(Service.A, "Brooklyn-bound", "to Far Rockaway",
                                false));
                        arrivals.add(new Train(Service.N, "Queens-bound", "to Steinway St", true));

                        /* Ask the adapter to update the information in the RecyclerView */
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                arrivals.clear();
                adapter.notifyDataSetChanged();
            }
        });
        /* Add this string request to the request queue; request will not be made otherwise. */
        requestQueue.add(stringRequest);
    }
}
