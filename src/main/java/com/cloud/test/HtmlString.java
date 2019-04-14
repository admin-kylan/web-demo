package com.cloud.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * className HtmlString
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 11:46
 */
public class HtmlString {

    private String htmlName = "index.html";


    //private String htmlName = "test.html";

    public String getHtml()  {
        String html = null;
        try {
            html = FileUtils.readFileToString(
                    new File("/Java/IntellijIdeaHouse/web-demo/src/main/java/com/cloud/test/" + htmlName), "utf-8");
        } catch (IOException e) {
            html = "";
        }
        return html;
    }



}
