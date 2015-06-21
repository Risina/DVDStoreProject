/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.ejb.EJBException;
import util.StoreBookingUtil;
import util.StoreDVDCopyUtil;
import util.StoreDVDUtil;


/**
 *
 * @author Risina
 */
public class RestClient {
    
    private static final String SERVER_ADDRESS = "http://localhost:8080/DVDStoreWeb/webresources/";
    private String getData(String uri) {
        
        HttpURLConnection conn = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(uri);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

//            if (conn.getResponseCode() != 200) {
//                    throw new RuntimeException("Failed : HTTP error code : "
//                                    + conn.getResponseCode());
//            }

            br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                   builder.append(output);
            }
            
            System.out.print(uri+" Output: "+builder.toString()+"\n");
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
    
    private String postData(String uri, String input) {
        
        StringBuilder builder = new StringBuilder();
        String output = "";
        try {
 
		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
 
		
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
 
//		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//			throw new RuntimeException("Failed : HTTP error code : "
//				+ conn.getResponseCode());
//		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
 
		
//		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			builder.append(output);
		}
                System.out.print(uri+" Output: "+builder.toString()+"\n");
		conn.disconnect();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	 }
        
        return builder.toString();
    }
    
    public List<StoreDVDUtil> getDVDs() {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDUtil>>() {}.getType();
        List<StoreDVDUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"dvd"), listType);  
        return list;
    }
    
    public String addDVD(StoreDVDUtil util) {
        return postData(SERVER_ADDRESS+"dvd", new Gson().toJson(util));
    }
    
    public String authenticateEmployee(String credentials) {
        return getData(SERVER_ADDRESS+"employee/login/"+credentials);
    }
    
    public String authenticateCustomer(String credentials) {
        return getData(SERVER_ADDRESS+"customer/login/"+credentials);
    }

    public List<StoreDVDUtil> getDVDsByTitle(String title) {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDUtil>>() {}.getType();
        List<StoreDVDUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"dvd/title/"+title), listType);  
        return list;
    }

    public List<StoreDVDUtil> getDVDsByRating(String rating) {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDUtil>>() {}.getType();
        List<StoreDVDUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"dvd/rating/"+rating), listType);  
        return list;
    }

    public List<StoreDVDUtil> getDVDsByFormat(String format) {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDUtil>>() {}.getType();
        List<StoreDVDUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"dvd/format/"+format), listType);  
        return list;
    }

    public List<StoreDVDUtil> getDVDsByYear(String year) {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDUtil>>() {}.getType();
        List<StoreDVDUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"dvd/year/"+year), listType);  
        return list;
    }

    public void addCopy(StoreDVDCopyUtil dvdCopy) {
        postData(SERVER_ADDRESS+"copy", new Gson().toJson(dvdCopy));
    }

    public List<StoreDVDCopyUtil> getCopiedByDVDId(Long dvdId) {
        java.lang.reflect.Type listType = new TypeToken<List<StoreDVDCopyUtil>>() {}.getType();
        List<StoreDVDCopyUtil> list = new Gson().fromJson(getData(SERVER_ADDRESS+"copy/"+dvdId), listType);  
        return list;
    }

    public String addBooking(StoreBookingUtil booking) {
        return postData(SERVER_ADDRESS+"booking", new Gson().toJson(booking));
    }
}
