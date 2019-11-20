package com.bin.yihai.provider.user.service;

import com.bin.yihai.common.dto.UserRegisterDto;
import com.bin.yihai.common.vo.R;

public interface UserService {
    //用户注册
    R save(UserRegisterDto userLogDto);
    //检验用户是否已存在
    R check(String msg);
}
