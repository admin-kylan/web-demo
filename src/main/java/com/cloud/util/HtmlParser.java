package com.cloud.util;

import com.cloud.entity.AsinEntity;
import com.cloud.load.LoadTask;
import com.cloud.service.AsinService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.toilelibre.libe.curl.Curl.curl;

/**
 * className HtmlParser
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 10:19
 */
public class HtmlParser implements Runnable {

    private String html;

    private String type;

    private AsinService asinService;

    private String searchName;

    private String http = "https://www.amazon.com";

    private String page;


    public HtmlParser(String html, String type, String searchName, AsinService asinService, String page) {
        this.html = html;
        this.type = type;
        this.searchName = searchName;
        this.asinService = asinService;
        this.page = page;
    }

    @Override
    public void run() {
        Document document = null;
        String result = curl ().lUpperCase ().$ (html);
        System.out.println(result);
        document = Jsoup.parse(result);

        if(null == document){
            return;
        }
        Elements elements = document.select("div[data-index]");
        for (Element src : elements) {

            Elements e = src.select("a.a-link-normal");
            String href = e.attr("href");
            String assign = src.attr("data-asin");
            if (StringUtils.isBlank(assign)) {
                continue;
            }
            //保存进数据库
            AsinEntity asinEntity = new AsinEntity();
            asinEntity.setAsinId(assign);
            asinEntity.setSearchName(searchName);
            asinEntity.setType(type);
            asinEntity.setUrl(http + href);
            asinService.saveOrUpdate(asinEntity);

        }
        //如果是第一页才执行
        if(StringUtils.equals("1", page)){
            //继续执行下一页
            Elements pagesElement = document.select(".a-pagination");
            int length = Integer.parseInt(pagesElement.get(0).select("li").get(pagesElement.get(0).select("li").size() - 2).text());

            //执行加下来的页数
            for (int i = 2; i <= length; i++) {
                System.out.println(i);
                LoadTask loadTask = new LoadTask(searchName, String.valueOf(i), asinService, type);
                Thread thread = new Thread(loadTask);
                thread.start();
            }
        }

    }
}
