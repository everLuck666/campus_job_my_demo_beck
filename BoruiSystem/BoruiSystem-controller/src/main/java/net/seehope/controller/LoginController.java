package net.seehope.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.seehope.UserService;
import net.seehope.common.RestfulJson;
import net.seehope.exception.PassPortException;
import net.seehope.jwt.JWTUtils;
import net.seehope.pojo.Users;
import net.seehope.pojo.bo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("user")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class LoginController {
    Logger log = LoggerFactory.getLogger("LoginController");
    @Autowired
    UserService userService;


    @ApiOperation("管理员登录获取token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户账号", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    @Transactional
    @PostMapping(value = "login",produces="application/json;charset=UTF-8")
    public RestfulJson loginManger(@RequestBody UserBo bo){
        Users usrs = userService.getUserInfo(bo.getUsername(), bo.getType());
        if(usrs == null){
//            throw new RuntimeException("用户不存在");

            return RestfulJson.errorMsg("用户不存在");

        }
        int version = Integer.valueOf(usrs.getVersion());
        version++;
        if(version == 1000){
            version = 0;
        }
        usrs.setVersion(version+"");
        userService.updateVersion(version+"",bo.getUsername());//版本号+1

        Map<String,String> map = new HashMap();

        try {
            Users users =  userService.login(bo);
            if(users.getIdentity()==-1){
                return RestfulJson.errorMsg("管理员已经被删除");
            }
            Map<String, String> payload = new HashMap<>();
            payload.put("userID", users.getUserId());
            System.out.println("----------------------");
            System.out.println("userID:" +  users.getUserId());
            System.out.println("----------------------");
            payload.put("version",users.getVersion());
            log.info("管理员版本号"+users.getVersion());
            payload.put("identity", users.getIdentity() + "");
            String token = JWTUtils.getToken(payload);
            map.put("token", token);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, +300);
            Date cd = calendar.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String time = simpleDateFormat.format(cd);
            log.info("管理员的token过期时间是" + time);
            map.put("expired", time);
            map.put("identity", users.getIdentity() + "");
        } catch (PassPortException e){
            return RestfulJson.errorMsg("密码错误");
        }catch (Exception e){
            return RestfulJson.errorMsg("管理员不存在或者找到了两个用户");
        }
        return RestfulJson.isOk(map);
    }

}
