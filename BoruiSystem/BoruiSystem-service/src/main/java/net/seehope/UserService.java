package net.seehope;

import net.seehope.pojo.*;
import  net.seehope.pojo.bo.*;

import java.util.List;
import java.util.Map;


public interface UserService {

    //查询用户的信息
    Users getUserInfo(String sno, String type);


    Student getStudentInfo(String userID);

    Schoolmanager getTeacherInfo(String userID);

    // 修改学生信息
    void updateStudentInfo(Student student, String sno);

    // 修改老师信息
    void updateTeacherInfo(Schoolmanager teacher, String teacherID);


    //删除用户信息
    void deleteUser(String userId);

    //存用户信息
    void insertUser(Users user,int identity);

    Users login(UserBo bo);


    //判断用户存不存在
    boolean isExist(String userId);

    //得到所有管理员
    List<Users> getAllManagers();

    //更新版本号
    void updateVersion(String version,String userId);

    // 注册用户
    void register(UserBo bo) throws Exception;

    // 得到所有学生的信息
    List<Student> getAllStudentInfo();

    // 查询学生应聘岗位进度
    List getStudentJobProcess(String studentID);

    // 发布帖子
    void postArticle(Post post) throws Exception;

    // 得到帖子信息
    List<Post> getPostArticle(int pageNum) ;

    // 得到帖子的总页数
    int getPostArticleNum();

    // 得到评论信息
    List<Comment> getPostComment(int pageNum, String postID);

    // 得到评论总数
    int getPostCommentNum(String postID);

    // 发布帖子评论
    void postComment(Comment comment) throws Exception;

    // 得到学生就业数据
    Map getJobInformation();

    // 得到通知信息
    List getInform(String userID);

    // 用户对于企业邀请的意愿
    void userIntention(String userID, String enterpriseID, String status);



}
