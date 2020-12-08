package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")    // HttpServletRequest   请求对象接口
    public void http(HttpServletRequest request, HttpServletResponse response){
        // 获取请求数据    HttpServletResponse -> 响应对象接口
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();   // Enumeration -> 迭代器
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+ " " +value);
        }
        System.out.println(request.getParameter("code"));

        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
        ) {
            writer.write("<hl>牛客网</hl>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET请求（获取数据，默认即为GET请求）

    @RequestMapping(path = "/students",method = RequestMethod.GET)   //常用
    @ResponseBody   //返回字符串
    public String getStudents(
        @RequestParam(name = "current",required = false,defaultValue = "1") int current,
        @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    // /student/123

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    // POST请求（提交数据）

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 响应动态HTML

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;
    }

    // 返回String
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","南京大学");
        model.addAttribute("age",118);
        return "/demo/view";
    }

    // 响应JSON数据(异步请求)
    // Java 对象 -> JSON对象 -> JS对象（浏览器响应）（跨语言）

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000.00);
        return emp;
    }

    // 返回一组员工
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","李四");
        emp.put("age",24);
        emp.put("salary",9000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","王五");
        emp.put("age",25);
        emp.put("salary",10000.00);
        list.add(emp);
        return list;
    }

    // Cookie示例

    @RequestMapping(path = "/cookie/set", method = RequestMethod.GET)
    @ResponseBody // cookie存放于客户端，少量数据
    public String setCookie(HttpServletResponse response){  // 响应报文头部
        // 创建cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        // 设置cookie生效范围
        cookie.setPath("/community/alpha");
        // 设置cookie生存时间，600s，存放在硬盘中，过期自动失效
        cookie.setMaxAge(60*10);
        // 发送cookie
        response.addCookie(cookie);

        return "set cookie";
    }

    @RequestMapping(path = "/cookie/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code){  // 获得某一个cookie
        System.out.println(code);
        return "get cookie";
    }

    // session示例

    @RequestMapping(path = "/session/set", method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session){  // SpringMVC自动创建session，数据存放于内存中
        session.setAttribute("id",1);
        session.setAttribute("name", "Bob");
        return "set session";
    }

    @RequestMapping(path = "/session/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session){
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "get session";
    }

    // ajax示例
    @RequestMapping(path = "/ajax", method = RequestMethod.POST)  // post请求，异步提交数据，返回字符串
    @ResponseBody
    public String testAjax(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return CommunityUtil.getJSONString(0,"操作成功");
    }

}
