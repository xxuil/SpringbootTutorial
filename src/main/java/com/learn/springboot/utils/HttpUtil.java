package com.learn.springboot.utils;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 简易的Http请求辅助类
 */
public class HttpUtil {

    /**
     * Initialize HttpURLConnection
     * @param url input URL
     * @return HttpURLConnection
     */
    private static HttpURLConnection initConnection(String url){
        URL httpURL;
        try {
            httpURL = new URL(url);
            return (HttpURLConnection) httpURL.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Get method for HttpRequest
     * @param url input URL
     * @return String
     */
    public static String doGet(String url){
        HttpURLConnection connection = initConnection(url);
        InputStream inputStream = null;
        BufferedReader reader = null;
        String result = null;

        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.connect();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder buffer = new StringBuilder();
                String temp;

                while((temp = reader.readLine())!= null) {
                    buffer.append(temp);
                    buffer.append("\r\n");
                }

                result = buffer.toString();
            }
        } catch (NullPointerException | IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(reader != null)
                    reader.close();

                if(inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
        return result;
    }


    /**
     * Post method for HttpRequest
     * @param url input URL
     * @return String
     */
    public static String doPost(String url, String param){
        HttpURLConnection connection = initConnection(url);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedReader reader = null;
        String result = null;

        try {
            connection.setRequestMethod("Post");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            outputStream = connection.getOutputStream();
            outputStream.write(param.getBytes());

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder buffer = new StringBuilder();
                String temp = null;
                while((temp = reader.readLine()) != null) {
                    buffer.append(temp);
                    buffer.append("\r\n");
                }
                result = buffer.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null)
                    reader.close();
                if(inputStream != null)
                    inputStream.close();
                if(outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
        return result;
    }
}
