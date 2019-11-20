package com.bin.yihai.api.user.service;

import com.bin.yihai.common.dto.UserRegisterDto;
import com.bin.yihai.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "UserProvider")
public interface UserService {
    //验证手机号是否存在
    @GetMapping("/provider/user/checkphone.do")
    R checkPhone(@RequestParam String phone);
    //验证邮箱是否存在
    @GetMapping("/provider/user/checkemail.do")
    R checkEmail(@RequestParam String email);
    //注册会员
    @PostMapping("/provider/user/register.do")
    R save(@RequestBody UserRegisterDto registerDto);
}
