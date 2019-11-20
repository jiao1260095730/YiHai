package com.bin.yihai.provider.user.service.impl;

import com.bin.yihai.common.config.SystemConfig;
import com.bin.yihai.common.dto.UserRegisterDto;
import com.bin.yihai.common.utils.EncryptUtil;
import com.bin.yihai.common.utils.StringUtil;
import com.bin.yihai.common.vo.R;
import com.bin.yihai.entity.user.User;
import com.bin.yihai.provider.user.dao.UserDao;
import com.bin.yihai.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public R save(UserRegisterDto userRegisterDto) {
        if (!StringUtil.isEmpty(userRegisterDto.getPassword(), userRegisterDto.getPassword())){
            User user = userDao.selectByName(userRegisterDto.getPhone());
            if (user == null) {
                User u = new User();
                u.setPhone(userRegisterDto.getPhone());
                u.setPassword(EncryptUtil.rsaEnc(SystemConfig.PASS_PRIKEY, userRegisterDto.getPassword()));
                userDao.insert(u);

                return R.ok();
            }
        }
        return R.fail("注册失败");
    }

    @Override
    public R check(String msg) {
        if (!StringUtil.isEmpty(msg)) {
            User user = userDao.selectByName(msg);
            if (user!=null) {
                return R.fail("手机已经注册过，请直接登录");
            }else {
                return R.ok();
            }
        }else {
            return R.fail("参数不合法");
        }
    }
}
