package com.cmjones.subwaytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * The application's main activity.
 */
public class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "nyc-subway-tracker:Main";

    /** Request queue for network requests. */
    private RequestQueue requestQueue;

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
        final Button makeRequest = findViewById(R.id.makeRequest);
        makeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Make request button clicked");
            }
        });
    }
}
