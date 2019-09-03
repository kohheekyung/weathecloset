package com.weathercloset.sunkyoung.wcmain_2019.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class GetClothesRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://13.209.21.170/get_wc.php";
    private Map<String, String> params;


    public GetClothesRequest(String testtext, String wind, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        testtext ="-15";
        wind = "3";
        params.put("testtext", testtext);
        params.put("wind", wind);

    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
