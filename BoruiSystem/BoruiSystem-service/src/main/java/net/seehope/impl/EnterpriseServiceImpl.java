package net.seehope.impl;
import net.seehope.EnterpriseService;
import net.seehope.mapper.*;
import net.seehope.pojo.*;
import net.seehope.pojo.vo.InterestJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{
    @Autowired
    EnterpriseMapper enterpriseMapper;
    @Autowired
    EnterpriseRelationMapper enterpriseRelationMapper;

    @Autowired
    StationMapper stationMapper;
    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    IntentionMapper intentionMapper;

    @Override
    public void registerEnterpriseInfo(Enterprise enterprise, String userID) throws Exception {



        Enterprise enterpriseTemp = enterpriseMapper.selectOne(enterprise);
        if (enterpriseTemp == null) {
           String enterpriseID =  UUID.randomUUID().toString();
            enterprise.setId(enterpriseID);
            enterpriseMapper.insert(enterprise);
            EnterpriseRelation enterpriseRelation = new EnterpriseRelation();
            enterpriseRelation.setUserId(userID);
            enterpriseRelation.setEnterpriseId(enterpriseID);
            enterpriseRelationMapper.insert(enterpriseRelation);

        } else {
            throw new Exception("该企业已经被注册");
        }

    }

    @Override
    public boolean isExistEnterprise(String enterpriseName) {

        Enterprise enterprise = new Enterprise();
        enterprise.setName(enterpriseName);

        Enterprise enterpriseTemp = enterpriseMapper.selectOne(enterprise);

        if (enterpriseTemp != null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isRegisterEnterprise(String userID) {
        EnterpriseRelation enterpriseRelation = new EnterpriseRelation();
        enterpriseRelation.setUserId(userID);

        EnterpriseRelation enterpriseRelationTemp = enterpriseRelationMapper.selectOne(enterpriseRelation);

        if (enterpriseRelationTemp != null) {
            return true;
        }
        return false;
    }

    @Override
    public void publishJob(Station station, String userID) throws Exception {
        Station job = new Station();

        EnterpriseRelation relation = new EnterpriseRelation();
        relation.setUserId(userID);

        EnterpriseRelation relationValue = enterpriseRelationMapper.selectOne(relation);
        if (relationValue == null) {
            throw new Exception("该用户不是企业人员");
        }

//        Enterprise enterprise = new Enterprise();
//        enterprise.setId(relationValue.getEnterpriseId());
//
//        Enterprise enterpriseValue = enterpriseMapper.selectOne(enterprise);
        station.setEnterpriseId(relationValue.getEnterpriseId());

        Station stationValue = stationMapper.selectOne(station);

        if (stationValue != null) {
            throw new Exception("该岗位已经存在，请不要重复发布");
        } else {
            station.setId(UUID.randomUUID().toString());
            station.setStatus(0);
            station.setCreateTime(new Date());
            station.setUpdateTime(new Date());
            stationMapper.insert(station);
        }
    }

    @Override
    public List<InterestJobVo> getStudentInfoByEnterpriseID(String enterpriseID) {
        List<InterestJobVo> interestJobVos = new ArrayList<>();
        Apply apply = new Apply();
        apply.setStationId(enterpriseID);

        List<Apply> applyList = applyMapper.select(apply);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < applyList.size(); i++) {
            Student student = new Student();
            student.setSno(applyList.get(i).getStudentId());

            Student result = studentMapper.selectOne(student);
            InterestJobVo interestJobVo = new InterestJobVo();
            interestJobVo.setTime(format.format(applyList.get(i).getCreateTime()));
            interestJobVo.setStatus(result.getSchoolName());
            interestJobVo.setUserName(result.getUserName());
            interestJobVo.setPhone(result.getPhone());
            interestJobVo.setHobby(result.getHobby());
            interestJobVo.setAchieve(result.getAchieve());
            interestJobVo.setProject(result.getProject());
            interestJobVo.setMutto(result.getMutto());
            interestJobVo.setStatus(applyList.get(i).getStatus());
            interestJobVo.setSchoolName(result.getSchoolName());
            interestJobVo.setSno(result.getSno());

            interestJobVos.add(interestJobVo);

        }

        return interestJobVos;
    }

    @Override
    public void changeJobState(String stationID, String userID, String state) {
        Apply apply = new Apply();
        apply.setStudentId(userID);
        apply.setStationId(stationID);
        Apply result = applyMapper.selectOne(apply);

        applyMapper.delete(result);
        if (Integer.parseInt(result.getStatus()) == 3) {
            result.setStatus((Integer.parseInt(result.getStatus())) + "");
        } else {
            result.setStatus((Integer.parseInt(result.getStatus()) + 1) + "");
        }


        if (state.equals("-2")) {
            result.setStatus("-2");
        }
        applyMapper.insert(result);

    }

    @Override
    public List getJobIntention(String userID, String intention) {



        EnterpriseRelation enterpriseRelation = new EnterpriseRelation();
        enterpriseRelation.setUserId(userID);

        EnterpriseRelation enResult = enterpriseRelationMapper.selectOne(enterpriseRelation);
        String enterpriseID = enResult.getEnterpriseId();
        List<Student> students = null;
        if (intention.equals("ALL")) {
            students = studentMapper.selectAll();
        } else {
            Student student = new Student();
            student.setIntention(intention);
            students = studentMapper.select(student);
        }


        List<Student> users = new ArrayList<>();

        Station station = new Station();
        station.setEnterpriseId(enterpriseID);

        List<Station> stationList = stationMapper.select(station);

        for (int i = 0; i < students.size(); i++) {
            boolean flag = false;
            for(int j = 0; j < stationList.size(); j++) {
                Apply apply = new Apply();
                apply.setStudentId(students.get(i).getSno());
                apply.setStationId(stationList.get(j).getId());

                Apply result = applyMapper.selectOne(apply);
                if (result != null) {
                    System.out.println("&&&&&&&&&&&我是true" + students.get(i).getSno());
                    System.out.println("&&&&&&&&&&&我是true" + stationList.get(j).getId());
                   flag = true;
                }
            }
            if (!flag) {
                users.add(students.get(i));
            }
        }
        System.out.println("***********************");
        System.out.println(users.size());
        return users;
    }

    @Override
    public void inviteUser(String userID, String studentID) throws Exception {
        EnterpriseRelation enterpriseRelation = new EnterpriseRelation();
        enterpriseRelation.setUserId(userID);

        EnterpriseRelation enResult = enterpriseRelationMapper.selectOne(enterpriseRelation);
        String enterpriseID = enResult.getEnterpriseId();

        Intention intention = new Intention();
        intention.setUserId(studentID);
        intention.setEnterpirseId(enterpriseID);

        Intention result = intentionMapper.selectOne(intention);

        if (result == null) {
            intention.setStatus("0");
            intentionMapper.insert(intention);
        } else {
            throw new Exception("请不要重复邀请");
        }



    }

    @Override
    public List getUserInviteAcc(String userID) {
        List list = new ArrayList();

        EnterpriseRelation enterpriseRelation = new EnterpriseRelation();
        enterpriseRelation.setUserId(userID);
        EnterpriseRelation relation = enterpriseRelationMapper.selectOne(enterpriseRelation);

        Intention intention = new Intention();
        intention.setEnterpirseId(relation.getEnterpriseId());
        intention.setStatus("1");
        List<Intention> intentionList = intentionMapper.select(intention);

        System.out.println("企业id是++++++++++");

        for (int i = 0; i < intentionList.size(); i++) {
            Student student = new Student();
            student.setSno(intentionList.get(i).getUserId());
            Student sResult = studentMapper.selectOne(student);
            Map map = new HashMap();
            map.put("userName", sResult.getUserName());
            map.put("userID", sResult.getSno());
            list.add(map);
        }

        return list;
    }
}
