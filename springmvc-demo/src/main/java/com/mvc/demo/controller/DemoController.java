package com.mvc.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<JSONObject> list = getListDate();
        request.setAttribute("list",list);

        return "index";

    }


    /**
     *  这里返回的数据 [{"name":"老师"}, {"name":"教授"}, {"name":"学生"}]
     * 这里是自己造的数据
     * @return  [{"name":"老师"}, {"name":"教授"}, {"name":"学生"}]
     */
    public List<JSONObject> getListDate(){

        JSONObject jsonObject = new JSONObject();
        List<JSONObject> list = new ArrayList<JSONObject>();
        jsonObject.put("name", "老师");
        list.add(jsonObject);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "教授");
        list.add(jsonObject1);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name", "学生");
        list.add(jsonObject2);
        return list;
    }


    /**
     * 这个方法会跳转到以form开头的jsp文件
     * @return
     */
    @RequestMapping(value = "form")
    public String form() {
        return "form";
    }

    /**
     * 这个方法会跳转到以form开头的jsp文件
     * @param request
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.POST)
    @ResponseBody
    public String doForm(@RequestParam("name") String name,
                         @RequestParam("age") String age,
            HttpServletRequest request) {

        System.out.println("name="+name+"---"+"age="+age);


/*        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name="+name+"---------"+"age="+age);
        Map<String , String> map = new HashMap<String, String>();
        map.put("name" , name);
        map.put("age" , age);*/
        git status "/mvc/demo/form";
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
