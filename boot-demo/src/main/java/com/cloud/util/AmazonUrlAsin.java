package com.cloud.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

/**
 * className AmazonUrlAsin
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 10:10
 */
public class AmazonUrlAsin {

    /**
     * 构造查询的url
     *
     * @param searchName
     * @return
     */
    public String getUrl(String searchName, String page) {

        String url = "";
        if(StringUtils.equals("1", page)){
            url = "https://www.amazon.com/s?__mk_zh_CN=%E4%BA%9A%E9%A9%AC%E9%80%8A%E7%BD%91%E7%AB%99&i=aps&k="+searchName+"&ref=nb_sb_noss&url=search-alias%3Daps";
        }else{

            String qid = String.valueOf(System.currentTimeMillis());
            qid.substring(0, 10);
            url = "https://www.amazon.com/s?k=" + searchName + "&page=" + page + "&__mk_zh_CN=%E4%BA%9A%E9%A9%AC%E9%80%8A%E7%BD%91%E7%AB%99&qid="+qid+"&ref=sr_pg_" + page;

        }

        return url;
    }


    /**
     * 发送http get 请求，获取返回的结果
     *
     * @throws IOException
     */
    public String getString(String searchName, String page)  {
//        String html;
//        CloseableHttpResponse response;
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpget = new HttpGet(getUrl(searchName, page));
//
//        try {
//            response = httpclient.execute(httpget);
//            html = EntityUtils.toString(response.getEntity(), "utf-8");
//        } catch (IOException e) {
//            html = "";
//        }
        String html = getUrl(searchName, page);
        return html;
    }

    public static void main(String[] args) {
        String html = "";
                CloseableHttpResponse response;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.amazon.com/s?__mk_zh_CN=%E4%BA%9A%E9%A9%AC%E9%80%8A%E7%BD%91%E7%AB%99&i=aps&k=baby&ref=nb_sb_noss&url=search-alias%3Daps");

        try {
            response = httpclient.execute(httpget);
            html = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            html = "";
        }
        System.out.println(html);
    }

}
