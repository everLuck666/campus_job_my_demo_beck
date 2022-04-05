package net.seehope.controller;


import net.seehope.EnterpriseService;
import net.seehope.common.RestfulJson;
import net.seehope.pojo.Station;
import net.seehope.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RequestMapping("enterprise")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    // 发布岗位
    @PostMapping(value = "station",produces="application/json;charset=UTF-8")
    public RestfulJson updateStudentInfo(@RequestBody Station station, HttpServletRequest request) throws Exception {

        enterpriseService.publishJob(station, request.getAttribute("userID").toString());

        return RestfulJson.isOk("成功");
    }

    // 得到当前岗位应聘人信息
    @GetMapping(value = "station/{enterpriseID}",produces="application/json;charset=UTF-8")
    public RestfulJson getStudentInfoByEnterpriseID(@PathVariable("enterpriseID") String enterpriseID) throws Exception {


        return RestfulJson.isOk(enterpriseService.getStudentInfoByEnterpriseID(enterpriseID));
    }

    // 处理该候选人在该岗位的状态
    @PostMapping(value = "changeStationState",produces="application/json;charset=UTF-8")
    public RestfulJson changeJobState(@RequestBody Map map) {

        enterpriseService.changeJobState(map.get("stationID").toString(), map.get("userID").toString(), map.get("state").toString());

        return RestfulJson.isOk("成功");
    }





}
