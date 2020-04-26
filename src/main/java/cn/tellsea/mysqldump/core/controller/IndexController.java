package cn.tellsea.mysqldump.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 视图控制器
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Controller
public class IndexController {

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }
}
