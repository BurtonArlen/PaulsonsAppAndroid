package com.inboundrx.paulsensbeaconsapp.ui.services;

import com.inboundrx.paulsensbeaconsapp.ui.CallConstants;
import com.inboundrx.paulsensbeaconsapp.ui.StringConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arlen on 7/12/17.
 */

public class WebRequest {
    public static void dataRequest(String /*placeholder*/, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(CallConstants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(StringConstants.ENDPOINT_QUERY, /*placeholder*/)
                .addQueryParameter(StringConstants.ENDPOINT_KEYWORD, StringConstants.ENDPOINT_TYPE)
                .addQueryParameter(StringConstants.KEY_PARAM, StringConstants.);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public ArrayList</*placeholder*/> processResults(Response response){
        ArrayList</*placeholder*/> beers = new ArrayList<>();

        try{
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                JSONObject allDataJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = allDataJSON.getJSONArray("data");
                for (int i = 0; i < resultsJSON.length(); i++){
                    JSONObject dataJSON = resultsJSON.getJSONObject(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return /*placeholder*/;
    }
}
