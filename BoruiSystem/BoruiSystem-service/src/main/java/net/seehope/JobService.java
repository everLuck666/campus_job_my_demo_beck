package net.seehope;

import net.seehope.pojo.Station;

import java.util.List;

public interface JobService {


    // 得到岗位信息

    List getJobListByInfo(Station job);


    // 申请岗位
    void applyJob(String userID, String jobID) throws Exception;

    // 通过岗位的审核
    void verifyJob(String jobID, String status);

    // 查看公司发布的岗位
    List getEnterprisePublishJob(String userID) throws Exception;

    // 删除岗位
    void deleteJob(String enterpriseID);

    // 模糊查找
    List getJobLike(String search);
}
