package com.bin.yihai.api.user.web;

import com.bin.yihai.api.user.service.UserService;
import com.bin.yihai.common.dto.UserRegisterDto;
import com.bin.yihai.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "会员服务相关操作",tags = "会员服务相关操作")
public class UserController {
    @Autowired
    private UserService userService;
    //验证手机号是否存在
    @ApiOperation(value = "校验手机号是否存在",notes = "校验手机号是否存在")
    @GetMapping("/api/user/checkphone.do")
    public R checkPhone(@RequestParam String phone) {
        return userService.checkPhone(phone);
    }
    //验证邮箱是否存在
    @ApiOperation(value = "校验邮箱是否存在",notes = "校验邮箱是否存在")
    @GetMapping("/api/user/checkemail.do")
    public R checkEmail(@RequestParam String email) {
        return userService.checkEmail(email);
    }
    //注册会员
    @ApiOperation(value = "注册会员",notes = "注册会员")
    @PostMapping("/api/user/register.do")
    public R save(@RequestBody UserRegisterDto registerDto){
        return userService.save(registerDto);
    }
}
