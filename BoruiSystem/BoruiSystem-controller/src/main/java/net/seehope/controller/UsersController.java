package net.seehope.controller;

import net.seehope.EnterpriseService;
import net.seehope.OnlineService;
import net.seehope.UserService;
import net.seehope.common.RestfulJson;
import net.seehope.pojo.Comment;
import net.seehope.pojo.Intention;
import net.seehope.pojo.Post;
import net.seehope.pojo.Student;
import net.seehope.pojo.bo.UserBo;
import net.seehope.pojo.vo.StudentChatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping("users")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UsersController {


    @Autowired
    UserService userService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    OnlineService onlineService;


    // 查询学生信息
    @GetMapping(value = "info",produces="application/json;charset=UTF-8")
    public RestfulJson getStudentInfo(HttpServletRequest request) {

        System.out.println(request.getAttribute("userID"));

        Student studentInfo = userService.getStudentInfo(request.getAttribute("userID").toString());

        System.out.println(studentInfo);

        return RestfulJson.isOk(studentInfo);
    }

    // 查询学生应聘的岗位
    @GetMapping(value = "jobProcess",produces="application/json;charset=UTF-8")
    public RestfulJson getStudentJobProcess(HttpServletRequest request) {

        return RestfulJson.isOk(userService.getStudentJobProcess(request.getAttribute("userID").toString()));
    }

    // 修改学生信息
    @PostMapping(value = "info",produces="application/json;charset=UTF-8")
    public RestfulJson updateStudentInfo(@RequestBody Student student, HttpServletRequest request) {
        userService.updateStudentInfo(student, request.getAttribute("userID").toString());
        return RestfulJson.isOk("成功");
    }


    // 用户注册
    @PostMapping(value = "register",produces="application/json;charset=UTF-8")
    public RestfulJson register(@RequestBody UserBo bo, HttpServletRequest request) throws Exception {
        userService.register(bo);
        return RestfulJson.isOk("成功");
    }

    // 判断用户有没有注册过企业
    @GetMapping(value = "enterprise",produces="application/json;charset=UTF-8")
    public RestfulJson isRegisterEnterprise(HttpServletRequest request) {
        if (enterpriseService.isRegisterEnterprise(request.getAttribute("userID").toString())) {
            return RestfulJson.errorMsg("该用户已经注册企业");
        }
        return RestfulJson.isOk("该用户没有注册企业");

    }

    // 得到所有学生用户信息
    @GetMapping(value = "users",produces="application/json;charset=UTF-8")
    public RestfulJson getAllStudentNameInfo() {
        List<Student> students = userService.getAllStudentInfo();
        List<StudentChatVo> studentChatVoList = new ArrayList<>();
        for(int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            StudentChatVo chatVo = new StudentChatVo();
            chatVo.setSno(student.getSno());
            chatVo.setUserName(student.getUserName());
           String photo =  onlineService.getHeaderPhoto(student.getSno());
           if (photo != null) {
               chatVo.setHeaderPhoto(photo);
           } else {
               chatVo.setHeaderPhoto("");
           }
            if (redisTemplate.opsForValue().get(student.getSno()) != null) {
                chatVo.setUserState(redisTemplate.opsForValue().get(student.getSno()).toString());
            } else {
                chatVo.setUserState("未登录");
            }

            studentChatVoList.add(chatVo);
        }
        return RestfulJson.isOk(studentChatVoList);

    }
    // 发表帖子
    @PostMapping(value = "post",produces="application/json;charset=UTF-8")
    public RestfulJson postArticle(@RequestBody Post post, HttpServletRequest request) throws Exception {
        post.setUserId(request.getAttribute("userID").toString());
        post.setPostId(UUID.randomUUID().toString());
        post.setCreateTime(new Date());
        userService.postArticle(post);
        return RestfulJson.isOk("成功");
    }

    // 获取帖子信息
    @GetMapping(value = "post/{pageNum}",produces="application/json;charset=UTF-8")
    public RestfulJson getPostArticle(@PathVariable("pageNum") String pageNum) {
        Map map = new HashMap();
        map.put("cardList", userService.getPostArticle(Integer.parseInt(pageNum)));
        map.put("totalCount", userService.getPostArticleNum());
        return RestfulJson.isOk(map);
    }

    // 获取评论内容
    @GetMapping(value = "post/{pageNum}/{postID}",produces="application/json;charset=UTF-8")
    public RestfulJson getPostComment(@PathVariable("pageNum") String pageNum, @PathVariable("postID") String postID) {
        Map map = new HashMap();
        map.put("commentList", userService.getPostComment(Integer.parseInt(pageNum), postID));
        map.put("totalCount", userService.getPostCommentNum(postID));
        return RestfulJson.isOk(map);
    }

    // 发布评论
    @PostMapping(value = "postComment",produces="application/json;charset=UTF-8")
    public RestfulJson postComment(@RequestBody Comment comment, HttpServletRequest request) throws Exception {
        comment.setUserId(request.getAttribute("userID").toString());
        comment.setCreateTime(new Date());
        comment.setCommentId(UUID.randomUUID().toString());
        userService.postComment(comment);
        return RestfulJson.isOk("成功");
    }

    // 获取通知信息
    @GetMapping(value = "inform",produces="application/json;charset=UTF-8")
    public RestfulJson getInform(HttpServletRequest request) {

        return RestfulJson.isOk(userService.getInform(request.getAttribute("userID").toString()));

    }

    // 企业邀请同意或者拒绝
    @PostMapping(value = "inform",produces="application/json;charset=UTF-8")
    public RestfulJson userIntention(@RequestBody Map map, HttpServletRequest request) {
        userService.userIntention(request.getAttribute("userID").toString(), map.get("enterpriseID").toString(), map.get("status").toString());
        return RestfulJson.isOk("");
    }



}
