package com.solvd.onlinestore.utils;

import java.util.HashMap;

public class DataUtil {
    private HashMap<String, Object> data;

    public DataUtil(){
        data = new HashMap<>();
        data.put("orderNumber", "DSW121313");
        data.put("creditCardNum", "1234567891234567");
        data.put("creditCardCsc", "123");
        data.put("cartTotal", 12.62);
        data.put("finalTotal", 321.32);
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
