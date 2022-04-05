package net.seehope;

import net.seehope.pojo.Online;

public interface WeChatService {
    // 修改用户登录状态
    public void updateUserOnlineState(Online online) ;
}
