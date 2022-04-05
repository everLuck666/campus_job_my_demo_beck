package net.seehope;

import net.seehope.pojo.Online;

public interface OnlineService {
    // 上传用户头像
    public void updateUserHeaderPhoto(String userID, String headerPhoto);
    // 获得学生头像地址
    String getHeaderPhoto(String userID);
}
