package com.cmjones.subwaytracker.lib;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.LinkedList;

/**
 * Class to extract information from an API response.
 */
public class TrainInfo {
    /**
     * Get the arrival times of the next arriving trains.
     *
     * @param json the API response
     * @return a list of the next arriving trains
     */
    public static List<String> getArrivalTimes(String json) {
        return new LinkedList<String>();
    }

    /**
     * Get the destinations of the next arriving trains.
     *
     * @param json the API response
     * @return a list of the new arriving trains
     */
    public static List<String> getDestinations(String json) {
        return new LinkedList<String>();
    }

    public static List<Train> getArrivals(String json) {
        return new LinkedList<Train>();
    }
}
