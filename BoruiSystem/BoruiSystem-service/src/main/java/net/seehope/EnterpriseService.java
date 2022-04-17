package net.seehope;

import net.seehope.pojo.Enterprise;
import net.seehope.pojo.Station;
import net.seehope.pojo.Student;
import net.seehope.pojo.vo.InterestJobVo;

import java.util.List;

public interface EnterpriseService {


    // 注册企业信息
    public void registerEnterpriseInfo(Enterprise enterprise, String userID) throws Exception;

    // 判断企业是否已经存在
    public boolean isExistEnterprise(String enterpriseName);

    // 判断用户是否已经注册过企业
    public boolean isRegisterEnterprise(String userID);

    // 发布岗位
    public void publishJob(Station station, String userID) throws Exception;

    //得到学生信息
    public List<InterestJobVo> getStudentInfoByEnterpriseID(String enterpriseID);

    //处理该候选人在改岗位上的状态
    public void changeJobState(String stationID, String userID, String state);

    // 获取主动邀约用户
    public List getJobIntention(String userID, String intention);

    // 邀请用户
    public void inviteUser(String userID, String studentID) throws Exception;

    // 得到邀请成功用户列表
    public List getUserInviteAcc(String userID);
}
