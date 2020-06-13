package top.easyblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.easyblog.conf.web.AjaxResult;
import top.easyblog.entity.User;
import top.easyblog.service.IUserService;

import java.util.Objects;


/**
 * @author ：huangxin
 * @modified ：
 * @since ：2020/06/10 19:52
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping(value = "/user/{id}")
    public User searchUser(@PathVariable(value = "id") int id) {
        return userService.getUserById(id);
    }


    @GetMapping(value = "/login")
    public String loginPage(){

        return "login";
    }


    @ResponseBody
    @GetMapping(value = "/ajax/{id}")
    public AjaxResult ajaxResultTest(@PathVariable(value = "id") int id){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult = ajaxResult.put("user", userService.getUserById(id));
        return Objects.requireNonNull(ajaxResult).success();
    }


}
