package net.seehope.controller;

import net.seehope.UserService;
import net.seehope.common.RestfulJson;
import net.seehope.pojo.Schoolmanager;
import net.seehope.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("school")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SchoolController {

    @Autowired
    UserService userService;



    // 查询老师信息
    @GetMapping(value = "info",produces="application/json;charset=UTF-8")
    public RestfulJson getTeacherInfo(HttpServletRequest request) {

        System.out.println(request.getAttribute("userID"));

        Schoolmanager teacherInfo = userService.getTeacherInfo(request.getAttribute("userID").toString());

        return RestfulJson.isOk(teacherInfo);
    }

    // 修改老师信息
    @PostMapping(value = "info",produces="application/json;charset=UTF-8")
    public RestfulJson updateStudentInfo(@RequestBody Schoolmanager teacher, HttpServletRequest request) {
        userService.updateTeacherInfo(teacher, request.getAttribute("userID").toString());
        return RestfulJson.isOk("成功");
    }

    // 获取学生就业信息
    @GetMapping(value = "jobInformation",produces="application/json;charset=UTF-8")
    public RestfulJson getJobInformation() {

        return RestfulJson.isOk(userService.getJobInformation());
    }






}
