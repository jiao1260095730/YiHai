package com.bin.yihai.provider.user.controller;

import com.bin.yihai.common.dto.UserRegisterDto;
import com.bin.yihai.common.vo.R;
import com.bin.yihai.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //验证手机号是否存在
    @GetMapping("/provider/user/checkphone.do")
    public R checkPhone(@RequestParam String phone) {
        return userService.check(phone);
    }
    //验证邮箱是否存在
    @GetMapping("/provider/user/checkemail.do")
    public R checkEmail(@RequestParam String email) {
        return userService.check(email);
    }
    //注册会员
    @PostMapping("/provider/user/register.do")
    public R save(@RequestBody UserRegisterDto registerDto){
        return userService.save(registerDto);
    }
}
