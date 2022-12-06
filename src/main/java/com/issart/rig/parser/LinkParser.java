package com.issart.rig.parser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class LinkParser {

    private final String phone;

    public LinkParser(String phone) {
        this.phone = phone;
    }

    // TODO Изменить парсинг ссылки и сделать обработку исключений

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
        String link;
        String html = getHtml(phone);
        if (html.equals("false")){
            System.out.println("Request wasn't successful");
            return "false";
        }
        Document doc = Jsoup.parse(html);
        List<Element> rows = doc.selectXpath("//div[@class='col-xs-12 col-md-8']");

        link = rows.stream()
                .filter(m -> m.text().contains("web-app.testing.bigrig.app.")).findFirst()
                .map(m -> m.selectXpath("span").attr("data-clipboard-text"))
                .orElse(null);
        return link;
    }

}
