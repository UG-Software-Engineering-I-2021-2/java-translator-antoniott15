package translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {
    static final String BASE_URL = "https://script.google.com/macros/s/AKfycbxJSBqm1GK9L2Rmw9Ru3UTJpY3cnky-1-gul_Po9aL0LhWrhkK0kLlnSGvRkqsfxnp5/exec";
    static final int REQUEST_TIMEOUT = 4000;
    static final String REQUEST_KEY = "User-Agent";
    static final String REQUEST_VALUE = "Mozilla/5.0";

    private Translator() {}

    public static String translate(String langFrom, String langTo, String text) throws IOException {
        if(text.length() >= 500 || text.length() == 0) {
            throw  new IOException("Length capacity exceed or text empty");
        }

        if(langFrom.length() == 0){
            throw  new IOException("no lang from given");
        }

        if(langTo.length() == 0){
            throw  new IOException("no lang to given");
        }

        String finalURL = urlBuilder(langFrom,langTo,text);

        URL url = new URL(finalURL);

        StringBuilder response = new StringBuilder();
        HttpURLConnection conn = connectionBuilder(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static String urlBuilder(String langFrom, String langTo, String text) throws UnsupportedEncodingException {
        return  String.format("%s?q=%s&target=%s&source=%s", BASE_URL,URLEncoder.encode(text, "UTF-8"), langTo, langFrom );
    }

    public static HttpURLConnection connectionBuilder(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(REQUEST_TIMEOUT);
        conn.setRequestProperty(REQUEST_KEY, REQUEST_VALUE);
        return conn;
    }
}
