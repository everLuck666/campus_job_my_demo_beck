package net.seehope.controller;

import net.seehope.JobService;
import net.seehope.common.RestfulJson;
import net.seehope.pojo.Station;
import net.seehope.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("job")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class JobController {

    @Autowired
    JobService jobService;

    // 查询岗位信息
    @PostMapping(value = "info",produces="application/json;charset=UTF-8")
    public RestfulJson getJobList(@RequestBody Station job) {

        return RestfulJson.isOk(jobService.getJobListByInfo(job));
    }

    // 模糊查询
    @PostMapping(value = "infolike",produces="application/json;charset=UTF-8")
    public RestfulJson getJobListLike(@RequestBody Map map) {

        return RestfulJson.isOk(jobService.getJobLike(map.get("search").toString()));
    }

    // 申请岗位
    @PostMapping(value = "apply",produces="application/json;charset=UTF-8")
    public RestfulJson applyJob(@RequestBody Map map, HttpServletRequest request) throws Exception {

        System.out.println("userID:" + request.getAttribute("userID").toString());
        System.out.println("stationId:" + map.get("stationId").toString());

        jobService.applyJob(request.getAttribute("userID").toString(), map.get("stationId").toString());

        return RestfulJson.isOk("申请岗位成功");

    }

    // 审核岗位
    @PostMapping(value = "verify",produces="application/json;charset=UTF-8")
    public RestfulJson verifyJob(@RequestBody Map map, HttpServletRequest request) {

        jobService.verifyJob(map.get("jobID").toString(), map.get("status").toString(), request.getAttribute("userID").toString());

        return RestfulJson.isOk("岗位通过审核");
    }

    // 查询公司发布的岗位
    @GetMapping(value = "enterpriseJob", produces="application/json;charset=UTF-8")
    public RestfulJson getEnterpriseJob(HttpServletRequest request) throws Exception {
        return RestfulJson.isOk(jobService.getEnterprisePublishJob(request.getAttribute("userID").toString()));
    }

    // 删除岗位
    @PostMapping(value = "deleteJob", produces="application/json;charset=UTF-8")
    public RestfulJson deleteJob(@RequestBody Map map) {
        System.out.println("删除岗位id");
        System.out.println(map.get("enterpriseID").toString());
        jobService.deleteJob(map.get("enterpriseID").toString());
        return RestfulJson.isOk("删除成功");

    }





}
