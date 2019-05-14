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
import android.widget.Button;
import android.widget.TextView;

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
public class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "nyc-subway-tracker:main";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    /** Request queue for network requests. */
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
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_n_circle);
        toolbar.setTitle(R.string.app_name);

        recyclerView = findViewById(R.id.trains);
        recyclerView.setHasFixedSize(true);

        // Use linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(this, arrivals);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(decoration);

        requestQueue = Volley.newRequestQueue(this);
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
                Log.d(TAG, "Refresh pressed");
                makeRequest();
                break;
            case R.id.action_settings:
                Log.d(TAG, "Settings pressed");
                break;
        }
        return true;
    }

    public void makeRequest() {
        String url = "http://datamine.mta.info/mta_esi.php?key=" + BuildConfig.API_KEY + "&feed_id=1";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        arrivals.clear();
                        /*
                        List<String> arrivalTimes = TrainInfo.getArrivalTimes(response);
                        List<String> destinations = TrainInfo.getDestinations(response);
                        for (int i = 0; i < arrivalTimes.size(); i++) {
                            arrivals.add(new Train(Service.A, destinations.get(i),
                                    destinations.get(i), false));
                        }
                        */
                        arrivals = TrainInfo.getArrivals(response);
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
