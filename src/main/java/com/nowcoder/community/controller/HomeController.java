package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.LikeService;
import com.nowcoder.community.service.UserService;
import com.nowcoder.community.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController implements CommunityConstant {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;  // 根据id返回用户名

    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page,
                                @RequestParam(name = "orderMode" , defaultValue = "0") int orderMode){
        // 方法调用之前，SpringMVC自动实例化Model和page,并将page注入Model。
        // 所以，在thymeleaf可以直接访问Page对象中的数据。
        page.setRows(discussPostService.findDiscussPostRows(0));    // 设置帖子总数量
        page.setPath("/index?orderMode=" + orderMode);  // 设置路径

        List<DiscussPost> list = discussPostService
                .findDiscussPosts(0,page.getOffset(),page.getLimit(),orderMode);  // 分页查询所有帖子
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if(list != null){
            for(DiscussPost post:list){
                Map<String, Object> map = new HashMap<>();  // Map<String, Object> map集合
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());  // 根据userId查询user
                map.put("user",user);

                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST,post.getId());
                map.put("likeCount", likeCount);
                // 把所有帖子信息封装到map里
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        model.addAttribute("orderMode", orderMode);
        return "/index";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage(){
        return "/error/500";
    }

    @RequestMapping(path = "/denied", method = RequestMethod.GET)
    public String getDeniedPage(){
        return "/error/404";
    }

}
