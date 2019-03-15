package com.aibaoxian.auth.controller;


import com.aibaoxian.auth.entity.UserInfo;
import com.aibaoxian.auth.enums.ErrorCodeEnum;
import com.aibaoxian.auth.mapper.UserInfoMapper;
import com.aibaoxian.auth.service.RedisService;
import com.aibaoxian.auth.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @Resource
    private UserInfoMapper userInfoMapper;


    @RequestMapping(value = {"/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        log.error("{}---------log-------{}", 1, 2);
        String s = "";
        s.substring(3, 5);
        return "hello world";
    }

    /**
     * 向redis存储值
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    @PostMapping("/redis/set")
    public R set(String key, String value) throws Exception {

        redisService.set(key, value);
        return R.ok();
    }

    /**
     * 获取redis中的值
     *
     * @param key
     * @return
     */
    @PostMapping("/redis/get")
    public R<String> get(String key, int ms) {
        R<String> r = new R<>();
        try {
            Thread.sleep(ms);
            String value = redisService.get(key);
            return r.setData(value);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(ErrorCodeEnum.RC_500, e.getMessage());
        }
    }


    /**
     * 获取数据库中的用户
     *
     * @param id
     * @return
     */
    @GetMapping("/user/get/{id}")
    public R<UserInfo> get(@PathVariable("id") int id) {
        R<UserInfo> r = new R<>();
        r.setData(userInfoMapper.selectByPrimaryKey(id));
        return r;
    }


    /**
     * 获取数据库中的用户
     *
     * @param id
     * @return
     */
    @GetMapping("/user/get/bean/{id}")
    public UserInfo get_bean(@PathVariable("id") int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }


    @Transactional
    @PostMapping("/user/insert")
    public R<Boolean> insertUser(UserInfo user) {
        R<Boolean> r = new R<>();

        int max = 10;
        int ranNum = RandomUtils.nextInt(max);
        int count = 0;
        for (int i = 0; i < max; i++) {
            userInfoMapper.selectByPrimaryKey(ranNum);
            count = userInfoMapper.insert(user);
            userInfoMapper.selectByPrimaryKey(ranNum);
            if (ranNum == i) {
                String a = null;
                a.length();
            }
        }
        if (count > 0) {
            return r.setData(true);
        } else {
            return r.setData(false);
        }
    }
}
