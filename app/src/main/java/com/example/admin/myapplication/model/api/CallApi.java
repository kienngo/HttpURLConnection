package com.example.admin.myapplication.model.api;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.example.admin.myapplication.model.GetDataUsers;
import com.example.admin.myapplication.model.Users;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CallApi extends AsyncTask<String, Void, String> {
    private final String METHOD_REQUEST_API = "GET";
    private final String RESPONSE_NAME = "name";
    private final String RESPONSE_ID = "id";
    private final String RESPONSE_FULL_NAME = "full_name";

    private Handler mHandler;

    public CallApi(Handler handler) {
        this.mHandler = handler;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = "";
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(METHOD_REQUEST_API);
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (Exception e) {

        }
        return response;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        ArrayList<Users> arrUser = new ArrayList<>();
        if (response != null) {
            try {
                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt(RESPONSE_ID);
                    String name = jsonObject.getString(RESPONSE_NAME);
                    String fullName = jsonObject.getString(RESPONSE_FULL_NAME);

                    Users users = new Users(id, name, fullName);
                    arrUser.add(users);
                }

                Message message = new Message();
                message.what = GetDataUsers.WHAT_CALL_API;
                message.obj = arrUser;
                mHandler.sendMessage(message);
            } catch (final Exception e) {

            }
        } else {

        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
