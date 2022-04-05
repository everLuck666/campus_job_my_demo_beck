package net.seehope.controller;

import net.seehope.UserService;
import net.seehope.pojo.Message;
import net.seehope.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class WsController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    UserService userService;

    /**
     * 单聊的消息的接受与转发
     * @param
     * @param message
     */
    @MessageMapping("/ws/chat")
//    @SendTo("/user/queue/chat")
    public void handleMessage(@RequestBody Message message ) throws Exception{

        System.out.println("我进来聊天了------");
//        Users user= userService.getUserInfo(request.getAttribute("userID").toString(), request.getAttribute("identity").toString());
//        message.setFromNickname(user.getUsername());
//        message.setFrom(user.getUsername());
        message.setCreateTime(new Date());
        System.out.println(message.getTo());
//        simpMessagingTemplate.convertAndSendToUser(message.getTo(),"/queue/chat",message);

//        simpMessagingTemplate.convertAndSend("/queue/chat", message);


//        simpMessagingTemplate.convertAndSendToUser(
//                String.valueOf(message.getTo()),
//                "/queue/chat",
//                message
//        );

        simpMessagingTemplate.convertAndSend("/queue/chat/" + message.getTo(), message);



    }


}
