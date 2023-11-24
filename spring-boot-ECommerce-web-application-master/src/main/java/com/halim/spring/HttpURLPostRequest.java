package com.halim.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HttpURLPostRequest {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public HttpURLPostRequest() {

    }

    public static void main(String[] args) throws Exception {

        HttpURLPostRequest obj = new HttpURLPostRequest();

        try {
            System.out.println("Testing 1 - Send Http POST request");
            obj.sendPost(args[0]);

        } finally {
            obj.close();
        }
    }

    public void close() throws IOException {
        httpClient.close();
    }

    public JSONObject sendPost(String id) throws Exception {

        HttpPost post = new HttpPost(Constants.CREDIT_CARD_FRAUD);

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("id", id));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String retSrc = EntityUtils.toString(entity);
                // parsing JSON
                JSONObject result = new JSONObject(retSrc); //Convert String to JSON Object
                return result;
            }
        }
        return null;

    }

    public JSONObject sendVerifyPost(String name, String age, String gender, String amount, String cnumber, String cvv){

        try {
            HttpPost post = new HttpPost(Constants.CREDIT_CARD_FRAUD);

            // add request parameter, form parameters
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("name", name));
            urlParameters.add(new BasicNameValuePair("age", age));
            urlParameters.add(new BasicNameValuePair("gender", gender));
            urlParameters.add(new BasicNameValuePair("cnumber", cnumber));
            urlParameters.add(new BasicNameValuePair("cvv", cvv));
            urlParameters.add(new BasicNameValuePair("amount", amount));

            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)) {

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    String retSrc = EntityUtils.toString(entity);
                    // parsing JSON
                    JSONObject result = new JSONObject(retSrc); //Convert String to JSON Object
                    return result;

                }
            }
            return new JSONObject();

        }catch (Exception e)
        {
            e.printStackTrace();
            return new JSONObject();
        }
    }

}
