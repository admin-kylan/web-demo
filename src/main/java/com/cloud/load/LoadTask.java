package com.cloud.load;

import com.cloud.service.AsinService;
import com.cloud.test.HtmlString;
import com.cloud.util.AmazonUrlAsin;
import com.cloud.util.HtmlParser;

/**
 * className LoadTask
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 22:14
 */
public class LoadTask implements Runnable {

    private String searchName;
    private String page;
    private AsinService asinService;
    private String type;

    public LoadTask(String searchName, String page, AsinService asinService, String type){
        this.searchName = searchName;
        this.page = page;
        this.type = type;
        this.asinService = asinService;
    }

    @Override
    public void run() {
        //这里是输入 baby 作为查询条件查询 返回一个html
        AmazonUrlAsin amazonUrlAsin = new AmazonUrlAsin();
        String html = amazonUrlAsin.getString(searchName, page);

        //这里是测试的一个html 搜索的条件是baby的一个html
        //String html = new HtmlString().getHtml();

        //类型，查询的一个类型，比如 婴儿baby 等等，自己定义

        HtmlParser htmlParser = new HtmlParser(html, type, searchName, asinService, page);
        Thread thread = new Thread(htmlParser);
        thread.start();
    }
}
