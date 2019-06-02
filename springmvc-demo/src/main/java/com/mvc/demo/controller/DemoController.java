package com.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * className DemoController
 * by Kylan
 *
 * @author Kylan
 * @date 2019-06-02 11:42
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 这个方法会跳转到以index开头的jsp文件
     * @param request
     * @return
     */
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request) {
        request.setAttribute("name","戴永标");
        return "index";
    }



    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "index1")
    @ResponseBody
    public String index1(HttpServletRequest request) {
        String back = "返回的内容";
        return back;
    }




}
