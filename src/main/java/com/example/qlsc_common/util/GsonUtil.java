package com.example.qlsc_common.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

class GsonUtil {
    public static JsonObject objectToJson(Object obj) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd' 'HH:mm:ss").create();
        JsonElement jsonElement = gson.toJsonTree(obj);
        return (JsonObject) jsonElement;
    }
}
