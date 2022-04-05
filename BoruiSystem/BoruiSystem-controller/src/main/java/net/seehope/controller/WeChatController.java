package net.seehope.controller;

import net.seehope.WeChatService;
import net.seehope.common.RestfulJson;
import net.seehope.pojo.Online;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RequestMapping("chat")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class WeChatController {

    @Autowired
    WeChatService weChatService;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping(value = "online/",produces="application/json;charset=UTF-8")
    public RestfulJson updateUserOnlineState(HttpServletRequest request) {

        redisTemplate.opsForValue().set(request.getAttribute("userID").toString(),"登录", 5, TimeUnit.SECONDS);

//        weChatService.updateUserOnlineState(online);

        return RestfulJson.isOk("成功");
    }



}
