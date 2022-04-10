package net.seehope.impl;

import net.seehope.JobService;
import net.seehope.common.JobStatus;
import net.seehope.mapper.*;
import net.seehope.pojo.*;
import net.seehope.pojo.vo.JobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    StationMapper stationMapper;

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Autowired
    EnterpriseRelationMapper relationMapper;

    @Autowired
    SchoolmanagerMapper schoolmanagerMapper;


    @Override
    public List getJobListByInfo(Station job) {


        List<Station> jobList =  stationMapper.select(job);

        List<JobVo> jobInfoList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");



        for(int i = 0; i < jobList.size(); i++) {
            Station jobInfo = jobList.get(i);
            JobVo jobVo = new JobVo();

            Enterprise enterprise = new Enterprise();
            enterprise.setId(jobInfo.getEnterpriseId());

            Enterprise enterpriseValue = enterpriseMapper.selectOne(enterprise);

            jobVo.setCompany(enterpriseValue.getName());
            jobVo.setCompanySrc(enterpriseValue.getImg());
            jobVo.setId(jobInfo.getId());
            jobVo.setAddress(jobInfo.getAddress());
            jobVo.setDemand(jobInfo.getDemand());
            jobVo.setEducation(jobInfo.getEducation());
            jobVo.setIndustry(jobInfo.getIndustry());
            jobVo.setMonth(jobInfo.getMonth());
            jobVo.setCreateTime(format.format(jobInfo.getCreateTime()));
            jobVo.setEnterpriseId(jobInfo.getEnterpriseId());
            jobVo.setNum(jobInfo.getNum());
            jobVo.setStatus(jobInfo.getStatus());
            jobVo.setName(jobInfo.getName());
            jobVo.setResponsibility(jobInfo.getResponsibility());
            jobVo.setProviderPhone(jobInfo.getProviderPhone());

            jobVo.setSalaryMax(jobInfo.getSalaryMax());
            jobVo.setSalaryMin(jobInfo.getSalaryMin());
            jobVo.setWorkBegin(format.format(jobInfo.getWorkBegin()));
//            jobVo.setWorkEnd(format.format(jobInfo.getWorkEnd()));
//            jobVo.setUpdateTime(format.format(jobInfo.getUpdateTime()));

            jobVo.setMoney(jobInfo.getSalaryMin() + "-" + jobInfo.getSalaryMax() + "*" + jobInfo.getMonth());

            jobInfoList.add(jobVo);
        }

        return jobInfoList;
    }

    @Override
    public void applyJob(String userID, String jobID) throws Exception {

        Apply apply = new Apply();
        apply.setStudentId(userID);
        apply.setStationId(jobID);

        Apply applyValue = applyMapper.selectOne(apply);

        if (applyValue != null) {
            throw new Exception("已经申请过该岗位");
        }

        apply.setCreateTime(new Date());
        apply.setStatus(JobStatus.WAIT.getType()+ "");

        applyMapper.insert(apply);
    }

    @Override
    public void verifyJob(String jobID, String status, String userID) {
        Station station = new Station();
        station.setId(jobID);

        Station stationValue = stationMapper.selectOne(station);
        if (stationValue.getStatus() != Integer.parseInt(status)) { // 表示没有通过审核
            stationMapper.delete(station);
            stationValue.setStatus(Integer.parseInt(status));
            stationMapper.insert(stationValue);
        }

        Schoolmanager schoolmanager = new Schoolmanager();
        schoolmanager.setId(userID);

        Schoolmanager searchManager = schoolmanagerMapper.selectOne(schoolmanager);
        schoolmanagerMapper.delete(searchManager);
        searchManager.setJobNum(searchManager.getJobNum()+1);
        schoolmanagerMapper.insert(searchManager);


    }

    @Override
    public List getEnterprisePublishJob(String userID) throws Exception {
        EnterpriseRelation relation = new EnterpriseRelation();
        relation.setUserId(userID);

        EnterpriseRelation result = relationMapper.selectOne(relation);
        if (result == null) {
            throw new Exception("刚用户不是企业用户");
        }
        Station station = new Station();
        station.setEnterpriseId(result.getEnterpriseId());

        List<Station> publistJobList = stationMapper.select(station);

        return publistJobList;
    }

    @Override
    public void deleteJob(String enterpriseID) {
        Station station = new Station();
        station.setId(enterpriseID);
        stationMapper.delete(station);
    }

    @Override
    public List getJobLike(String search) {

        System.out.println("模糊搜索，我搜索的是"+ search);
        if (search.equals("全部城市") || search.equals("全部岗位")) {
            Station station = new Station();
            station.setStatus(1);
            return stationMapper.select(station);
        }
        Example example = new Example(Station.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orCondition("address like '%" + search +"%'");
        criteria.orCondition("name like '%" + search +"%'");
        criteria.orCondition("industry like '%" + search +"%'");
        criteria.orCondition("education like '%" + search +"%'");

//        criteria.andCondition("status=1");
//        criteria.andEqualTo("status", "1");
        List<Station> result = new ArrayList<>();
       List<Station> stationList =  stationMapper.selectByExample(example);

       List<JobVo> jobInfoList = new ArrayList<>();





        for (int i = 0; i < stationList.size(); i++) {
            if (stationList.get(i).getStatus() == 1) {
                result.add(stationList.get(i));
            }
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");



        for(int i = 0; i < result.size(); i++) {
            Station jobInfo = result.get(i);
            JobVo jobVo = new JobVo();

            Enterprise enterprise = new Enterprise();
            enterprise.setId(jobInfo.getEnterpriseId());

            Enterprise enterpriseValue = enterpriseMapper.selectOne(enterprise);

            jobVo.setCompany(enterpriseValue.getName());
            jobVo.setCompanySrc(enterpriseValue.getImg());
            jobVo.setId(jobInfo.getId());
            jobVo.setAddress(jobInfo.getAddress());
            jobVo.setDemand(jobInfo.getDemand());
            jobVo.setEducation(jobInfo.getEducation());
            jobVo.setIndustry(jobInfo.getIndustry());
            jobVo.setMonth(jobInfo.getMonth());
            jobVo.setCreateTime(format.format(jobInfo.getCreateTime()));
            jobVo.setEnterpriseId(jobInfo.getEnterpriseId());
            jobVo.setNum(jobInfo.getNum());
            jobVo.setStatus(jobInfo.getStatus());
            jobVo.setName(jobInfo.getName());
            jobVo.setResponsibility(jobInfo.getResponsibility());
            jobVo.setProviderPhone(jobInfo.getProviderPhone());

            jobVo.setSalaryMax(jobInfo.getSalaryMax());
            jobVo.setSalaryMin(jobInfo.getSalaryMin());
            jobVo.setWorkBegin(format.format(jobInfo.getWorkBegin()));
//            jobVo.setWorkEnd(format.format(jobInfo.getWorkEnd()));
//            jobVo.setUpdateTime(format.format(jobInfo.getUpdateTime()));

            jobVo.setMoney(jobInfo.getSalaryMin() + "-" + jobInfo.getSalaryMax() + "*" + jobInfo.getMonth());

            jobInfoList.add(jobVo);
        }



        return jobInfoList;
    }
}
