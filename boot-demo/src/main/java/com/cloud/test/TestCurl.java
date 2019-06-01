package com.cloud.test;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.toilelibre.libe.curl.Curl.curl;
import static org.toilelibre.libe.curl.Curl.$;

/**
 * className TestCurl
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-15 00:10
 */
public class TestCurl {

    public static void main(String[] args) throws IOException {
        String str = "https://www.amazon.com/s?__mk_zh_CN=%E4%BA%9A%E9%A9%AC%E9%80%8A%E7%BD%91%E7%AB%99&i=aps&k=baby&ref=nb_sb_noss&url=search-alias%3Daps";
        String command = "curl -X GET " + str;
        String result = curl ().lUpperCase ().$ (str);
        System.out.println(result);
    }


}
