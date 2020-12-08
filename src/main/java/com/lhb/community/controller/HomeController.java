package com.lhb.community.controller;

import com.lhb.community.entity.DiscussPost;
import com.lhb.community.entity.Page;
import com.lhb.community.entity.User;
import com.lhb.community.service.DiscussPostService;
import com.lhb.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author littlelee
 * @date 2020/12/5 20:26
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){

        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (list != null){
            for (DiscussPost post : list) {
                Map<String,Object> map = new HashMap<>();

                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);

                discussPosts.add(map);

            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }

}
