package com.issart.rig.parser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkParser {

    private final String phone;

    public LinkParser(String phone) {
        this.phone = phone;
    }



    private String linkBuilder(String phoneNumber) {
        String baseUrl = "https://receive-sms.cc/US-Phone-Number/";
        return baseUrl + phoneNumber.replaceAll("\\s", "").replaceAll("[-()+]", "");
    }

    private String getHtml(String phone) throws IOException {
        Response response;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(linkBuilder(phone))
                    .method("GET", null)
                    .build();
            response = client.newCall(request).execute();
        } catch (Exception e){
            System.out.println("Wasn't able to reach https://receive-sms.cc/. Probably VPN or Proxy connection is needed");
            return "false";
        }
        if(!response.isSuccessful()){
            return "false";
        } else {
            assert response.body() != null;
            return response.body().string();
        }
    }

    public String getLink() throws IOException {
        String message = getMessage(getHtml(phone));
        if (message == null) return "false";

        Pattern regex = Pattern.compile(".*?(?<url>[Hh][Tt][Tt][Pp][Ss]?://\\S+).*?");
        Matcher matcher = regex.matcher(message);
        if (matcher.matches()) {
            System.out.println(matcher.group("url"));
            return matcher.group("url");
        }
        return "false";
    }

    private String getMessage(String html) throws IOException {
        String message;
        if (html.equals("false")){
            return null;
        }
        try {
            Document doc = Jsoup.parse(html);
            List<Element> rows = doc.selectXpath("//div[@class='col-xs-12 col-md-8']");

            message = rows.stream()
                    .filter(m -> m.text().contains("Please click on the link to provide information for your . https://testing.bigrig.app")).findFirst()
                    .get().text();
            return message;

        } catch (NoSuchElementException e){
            System.out.println("Message with link wasn't found on the page :<");
            return null;
        }
    }

}
