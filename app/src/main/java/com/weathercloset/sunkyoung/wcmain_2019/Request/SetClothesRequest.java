package com.weathercloset.sunkyoung.wcmain_2019.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SetClothesRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://13.209.21.170/add_wc_user.php";
    private Map<String, String> params;

    public SetClothesRequest(String testtext, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("testtext", testtext);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
