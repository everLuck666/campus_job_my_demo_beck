package net.seehope.impl;

import net.seehope.WeChatService;
import net.seehope.mapper.OnlineMapper;
import net.seehope.pojo.Online;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatServiceImpl implements WeChatService {
    @Autowired
    OnlineMapper onlineMapper;
    @Override
    public void updateUserOnlineState(Online online) {
        Online userOnline = new Online();
        userOnline.setUserId(online.getUserId());

        Online onlineTemp = onlineMapper.selectOne(userOnline);

        if(onlineTemp == null) {
            onlineMapper.insert(online);
            return ;
        }

        if (onlineTemp.getOnline() != onlineTemp.getOnline() ) {
            onlineMapper.delete(userOnline);
            onlineMapper.insert(online);
        }


    }
}
