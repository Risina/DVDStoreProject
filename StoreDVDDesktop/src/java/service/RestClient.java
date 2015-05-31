/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import util.StoreDVDUtil;


/**
 *
 * @author Risina
 */
public class RestClient {
    
    private static final String SERVER_ADDRESS = "http://192.168.1.101:8080/DVDStoreWeb/webresources/";
    private String getData(String uri) {
        
        HttpURLConnection conn = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(uri);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
            }

            br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                   builder.append(output);
            }
        }
        catch(Exception e) {
            
        }
        finally{
            if(conn!=null) {
                conn.disconnect();
            }
            
        }

        return builder.toString();
    }
    
    public List<StoreDVDUtil> getDVDs() {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDUtil>>() {}.getType();
        List<StoreDVDUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"dvd"), listType);  
        return list;
    }
}
