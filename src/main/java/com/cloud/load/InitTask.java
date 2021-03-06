package com.cloud.load;

import com.cloud.test.HtmlString;
import com.cloud.service.AsinService;
import com.cloud.util.AmazonUrlAsin;
import com.cloud.util.HtmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;

/**
 * className LoadTask
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 18:42
 */
@Component
public class InitTask implements ApplicationRunner {

    @Autowired
    private AsinService asinService;

    @Override
    public void run(ApplicationArguments args) {
        String searchName = "baby";
        String type = "baby";
        //固定第一页开始
        String page = "1";

        //执行初始化任务
        LoadTask loadTask = new LoadTask(searchName, page, asinService, type);
        Thread thread = new Thread(loadTask);
        thread.start();



    }
}
