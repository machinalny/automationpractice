package com.machinalny.automationpractice.utils;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockarooClient {
    public static JSONArray getUsers() throws IOException {
        URL url = new URL("https://my.api.mockaroo.com/automusermock.json?key=70a3d510");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        return new JSONArray(IOUtils.toString(conn.getInputStream()));
    }
}
