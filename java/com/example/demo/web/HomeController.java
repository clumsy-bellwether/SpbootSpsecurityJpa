package com.example.demo.web;

import com.example.demo.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YF-yangwen on 2018/5/28.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {//登录流程2
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }
}
