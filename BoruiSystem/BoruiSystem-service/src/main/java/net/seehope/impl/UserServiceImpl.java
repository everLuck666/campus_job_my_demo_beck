package net.seehope.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.seehope.UserService;
import net.seehope.common.UserType;
import net.seehope.exception.PassPortException;
import net.seehope.mapper.*;
import net.seehope.pojo.*;
import net.seehope.pojo.bo.UserBo;
import net.seehope.pojo.vo.JobProcessVo;
import net.seehope.util.ExcelFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SchoolmanagerMapper schoolmanagerMapper;

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    StationMapper stationMapper;

    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    OnlineMapper onlineMapper;


    @Override
    public Users getUserInfo(String sno, String type) {
        Users users = new Users();
        users.setUserId(sno);
        users.setIdentity(Integer.parseInt(type));
        Users userValue = usersMapper.selectOne(users);

      //  Users userValue = usersMapper.getUser(sno);
        if (userValue != null) {
            return userValue;
        }
        return null;
    }

    @Override
    public Student getStudentInfo(String userID) {

     Student student = new Student();

     student.setSno(userID);

     Student studentValue = studentMapper.selectOne(student);


         return studentValue;



    }

    @Override
    public Schoolmanager getTeacherInfo(String userID) {
        Schoolmanager teacher = new Schoolmanager();
        teacher.setId(userID);

        Schoolmanager teacherValue = schoolmanagerMapper.selectOne(teacher);

        return teacherValue;
    }

    @Override
    public void updateStudentInfo(Student student, String sno) {
        Student studentTemp = new Student();
        studentTemp.setSno(sno);
        student.setSno(sno);
        studentMapper.delete(studentTemp);
        studentMapper.insert(student);
    }

    @Override
    public void updateTeacherInfo(Schoolmanager teacher, String teacherID) {
        Schoolmanager teacherTemp = new Schoolmanager();
        teacher.setId(teacherID);

        Schoolmanager teacherInfo = schoolmanagerMapper.selectOne(teacherTemp);
        schoolmanagerMapper.delete(teacherTemp);

        teacherInfo.setAges(teacher.getAges());
        teacherInfo.setHiredate(teacher.getHiredate());
        teacherInfo.setPhone(teacher.getPhone());

        schoolmanagerMapper.insert(teacherInfo);
    }

    @Override
    public void deleteUser(String userId) {
//        Users user = new Users();
//        user.setUserId(userId);
//
//        if (isExist(user.getUserId())) {
//            Users userTemp = new Users();
//            userTemp.setIdentity(UserType.SUPERMANAGER.getType());
//            List list = usersMapper.select(userTemp);
//            if (list.size() == 1) {
//                throw new RuntimeException("还剩一个管理员，禁止删除");
//            }
//            usersMapper.delete(user);
//        } else {
//            throw new RuntimeException("账号不存在");
//        }


    }

    @Override
    public void insertUser(Users user, int identity) {
        if (isExist(user.getUserId())) {
            throw new RuntimeException("账号存在");
        } else {
            user.setIdentity(identity);
            user.setVersion("0");
            usersMapper.insert(user);

        }
    }

    @Override
    public Users login(UserBo bo) {
        Users user = null;

        System.out.println("-------登录的人：" + bo.getUsername());

        if (!StringUtils.isEmpty(bo.getUsername())) {
            Users temp = new Users();
            temp.setUserId(bo.getUsername());
            temp.setPassword(bo.getPassword());
            temp.setIdentity(Integer.parseInt(bo.getType()));
            try{
                user = usersMapper.selectOne(temp);
            }catch (Exception e){
                throw new RuntimeException("找到了两个用户");
            }
            if (user == null) {
                throw new RuntimeException("用户不存在");
            }
            if (!StringUtils.equals(bo.getPassword(), user.getPassword())) {
                throw new PassPortException("密码错误");
            }
        }

        return user;
    }





    @Override
    public boolean isExist(String userId) {
        Users users = new Users();
        users.setUserId(userId);

        Users users1 =  usersMapper.selectOne(users);
        if(users1 != null){
            return true;
        }

        return false;
    }

    @Override
    public List<Users> getAllManagers() {
        Users users = new Users();
//        users.setIdentity(UserType.SUPERMANAGER.getType());
        return usersMapper.select(users);
    }

    @Override
    public void updateVersion(String version,String userId) {
//        usersMapper.updateVersion(version,userId);

    }

    @Override
    public void register(UserBo bo) throws Exception {
        Users users = new Users();

        users.setUserId(bo.getUsername());

        Users usersTemp = usersMapper.selectOne(users);

        if (usersTemp != null) {
            throw new Exception("当前用户的账号已经被注册");
        }

        users.setIdentity(Integer.parseInt(bo.getType()));

        users.setPassword(bo.getPassword());
        users.setVersion(0+"");

        Users usersValue = usersMapper.selectOne(users);

        if (usersValue != null) {
            throw new Exception("当前用户已经存在");
        }

        usersMapper.insert(users);

    }

    @Override
    public List<Student> getAllStudentInfo() {
        List<Student> studentsList = studentMapper.selectAll();
        return studentsList;
    }

    @Override
    public List getStudentJobProcess(String studentID) {
        List<JobProcessVo> jobProcessList = new ArrayList<>();

        Apply apply = new Apply();
        apply.setStudentId(studentID);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        List<Apply> applyList = applyMapper.select(apply);
        for( int i = 0; i < applyList.size(); i++) {
            Station station = new Station();
            station.setId(applyList.get(i).getStationId());

            Station result = stationMapper.selectOne(station);

            Enterprise enterprise = new Enterprise();
            enterprise.setId(result.getEnterpriseId());
            Enterprise enterpriseResult = enterpriseMapper.selectOne(enterprise);

            JobProcessVo jobProcessVo = new JobProcessVo();
            jobProcessVo.setJobName(result.getName());
            jobProcessVo.setEnterpriseName(enterpriseResult.getName());
            jobProcessVo.setTime(format.format(applyList.get(i).getCreateTime()));
            jobProcessVo.setStatus(applyList.get(i).getStatus());
            jobProcessList.add(jobProcessVo);

        }

        return jobProcessList;
    }

    @Override
    public void postArticle(Post post) throws Exception {
        Post result = postMapper.selectOne(post);

        if (result == null) {
            postMapper.insert(post);
        } else {
            throw new Exception("改帖子已经发布过了，请不要重复发布");
        }
    }

    @Override
    public List<Post> getPostArticle(int pageNum) {

        System.out.println("******************");
        System.out.println("pageNum:" + pageNum);
        PageHelper.startPage(pageNum, 5);


        return postMapper.getAllPost();
    }

    @Override
    public int getPostArticleNum() {
        Post post = new Post();
       return postMapper.selectCount(post);
    }

    @Override
    public List<Comment> getPostComment(int pageNum, String postID) {
        Comment comment = new Comment();
        comment.setPostId(postID);
        PageHelper.startPage(pageNum, 5);
        List<Comment> commentList = commentMapper.getAllComment(postID);
        return commentList;
    }

    @Override
    public int getPostCommentNum(String postID) {
        Comment comment = new Comment();
        comment.setPostId(postID);

        return commentMapper.selectCount(comment);
    }

    @Override
    public void postComment(Comment comment) throws Exception {
        Online online = new Online();
        online.setUserId(comment.getUserId());

        Online result = onlineMapper.selectOne(online);

        comment.setUserSrc(result.getOnline());

        Comment cResult = commentMapper.selectOne(comment);

        if (cResult != null) {
            throw new Exception("请勿重复评论");
        } else {
            commentMapper.insert(comment);
        }
    }

}
