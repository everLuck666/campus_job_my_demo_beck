package net.seehope.impl;

import net.seehope.OnlineService;
import net.seehope.mapper.OnlineMapper;
import net.seehope.pojo.Online;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineServiceImpl implements OnlineService {
    @Autowired
    OnlineMapper onlineMapper;
    @Override
    public void updateUserHeaderPhoto(String userID, String headerPhoto) {
        Online online = new Online();
        online.setUserId(userID);

        Online onlineValue = onlineMapper.selectOne(online);

        if (onlineValue != null) {
            onlineMapper.delete(online);
        }

        online.setOnline(headerPhoto);

        onlineMapper.insert(online);
    }

    @Override
    public String getHeaderPhoto(String userID) {
        Online online = new Online();
        online.setUserId(userID);

        Online onlineValue = onlineMapper.selectOne(online);

        if (onlineValue != null) {
            return onlineValue.getOnline();
        }
        return null;
    }
}
