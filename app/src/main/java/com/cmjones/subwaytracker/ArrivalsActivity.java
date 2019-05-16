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
    List<Train> arrivals = new LinkedList<>();

    /**
     * Executes when the main activity loads.
     *
     * @param savedInstanceState state saved on the last pause
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrivals);

        requestQueue = Volley.newRequestQueue(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.ind_eighth_ave));

        recyclerView = findViewById(R.id.trains);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ArrivalsListAdapter(this, arrivals);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);
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
                Log.d(TAG, "Refresh button pressed!");
                makeRequest(1);
                break;
            case R.id.action_settings:
                Log.d(TAG, "Settings button pressed!");
                break;
        }
        return true;
    }

    /**
     * Initiate an API request to retrieve GTFS Realtime data
     */
    private void makeRequest(final int feedID) {
        String url = "http://datamine.mta.info/mta_esi.php?key=" + BuildConfig.API_KEY +
                "&feed_id=" + feedID;
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
        requestQueue.add(stringRequest);
    }
}
