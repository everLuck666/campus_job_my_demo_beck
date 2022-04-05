package net.seehope.controller;

import io.swagger.annotations.*;
import net.seehope.EnterpriseService;
import net.seehope.IndexService;
import net.seehope.OnlineService;
import net.seehope.common.FilePath;
import net.seehope.common.RestfulJson;
import net.seehope.mapper.OnlineMapper;
import net.seehope.pojo.Enterprise;
import net.seehope.pojo.Online;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/file")
@Api(tags = "静态资源上传",value = "StaticResourceController")
@CrossOrigin(origins = "*",maxAge = 3600)
public class StaticResourceController {

    @Autowired
    IndexService indexService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    OnlineService onlineService;

    //上传企业
    @PostMapping(value = "enterprise",produces="application/json;charset=UTF-8")

    public RestfulJson updateVideo(HttpServletRequest request, String name) throws Exception {


        System.out.println("进入上传文件");
        System.out.println("上传的企业是" + name);

        if (name == null) {
            throw new Exception("上传的企业信息为空");
        }

        if (enterpriseService.isExistEnterprise(name)) {
            throw new Exception("上传的企业已经被注册过了");
        }

        if (enterpriseService.isRegisterEnterprise(request.getAttribute("userID").toString())) {
            throw new Exception("该用户已经注册过企业");
        }

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        String fileName = null;
        String path = FilePath.images;

        fileName = indexService.update(files, path);
        String[] suffix = fileName.split("\\.");

        if (fileName == null) {
            throw new Exception("文件没有上传成功");
        }

        String titleName = name;
        titleName += ".";
        titleName += suffix[suffix.length-1];

        indexService.renameTo(fileName,titleName,path);

        Enterprise enterprise = new Enterprise();
        enterprise.setName(name);
        enterprise.setStatus(0);
        enterprise.setImg(titleName);
        enterpriseService.registerEnterpriseInfo(enterprise, request.getAttribute("userID").toString());

        return RestfulJson.isOk("上传成功");

    }


    //上传用户头像
    @PostMapping(value = "header",produces="application/json;charset=UTF-8")

    public RestfulJson updateUserHeaderSrc(HttpServletRequest request) throws Exception {


        System.out.println("进入上传文件");

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        String fileName = null;
        String path = FilePath.images;

        fileName = indexService.update(files, path);
        String[] suffix = fileName.split("\\.");

        if (fileName == null) {
            throw new Exception("文件没有上传成功");
        }

        String titleName = request.getAttribute("userID").toString();
        titleName += ".";
        titleName += suffix[suffix.length-1];

        indexService.renameTo(fileName,titleName,path);
        onlineService.updateUserHeaderPhoto(request.getAttribute("userID").toString(), titleName);

        return RestfulJson.isOk("上传成功");

    }





    //上传固件
//    @PostMapping(value = "zip",produces="application/json;charset=UTF-8")
//    @ApiOperation(value = "上传固件",notes = "file字段对应的是固件")
//    public RestfulJson updateZip(HttpServletRequest request, @ApiParam(name = "zipName",value = "固件的名字") String zipName,@ApiParam(name = "describe",value = "文件的描述") String describe) throws IOException {
//
//        if(zipName == null){
//            throw new RuntimeException("请填写固件的名字");
//        }
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
//        File tempFile = new File(FilePath.path);
//        String path = FilePath.zip;
//
//        String fileName = null;
//            if(StringUtils.equals("地面站",zipName)){
//                indexService.deleteFile(zipName,path);
//                videoService.deleteZipInformation(zipName);
//            }
//
//            if(videoService.isContain(zipName)){
//                throw new RuntimeException("这个固件名字已经被使用");
//            }
//
//
//        fileName = indexService.update(files, path);
//        String[] suffix = fileName.split("\\.");
//
//        if(fileName == null){
//            throw new RuntimeException("文件并没有上传成功");
//        }
//        String titleName = zipName;
//        zipName +=".";
//        zipName += suffix[suffix.length-1];
//        indexService.renameTo(fileName,zipName,path);
//
//        Video video = new Video();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createTime = simpleDateFormat.format(new Date());
//        video.setCreateTime(createTime);
//        video.setPath("static/zip/"+zipName);
//
//        video.setDescribestatic(describe);
//
//        video.setVideoName(titleName);
//        videoService.addVideo(video);
//        return RestfulJson.isOk("上传成功");
//
//    }

//
//    @PostMapping(value = "pdf",produces="application/json;charset=UTF-8")
//    @ApiOperation(value = "上传pdf",notes = "file字段对应的是固件")
//    public RestfulJson updatepdf(HttpServletRequest request, @ApiParam(name = "pdfName",value = "固件的名字") String pdfName,@ApiParam(name = "describe",value = "文件的描述") String describe) throws IOException {
//
//        if(pdfName == null){
//            throw new RuntimeException("请填写固件的名字");
//        }
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
//        File tempFile = new File(FilePath.path);
//        String path = FilePath.zip;
//
//        String fileName = null;
//
//        if(StringUtils.equals("地面站",pdfName)){
//            indexService.deleteFile(pdfName,path);
//            videoService.deleteZipInformation(pdfName);
//        }
//
//        if(videoService.isContain(pdfName)){
//            throw new RuntimeException("这个固件名字已经被使用");
//        }
//
//
//        fileName = indexService.update(files, path);
//        String[] suffix = fileName.split("\\.");
//
//        if(fileName == null){
//            throw new RuntimeException("文件并没有上传成功");
//        }
//        String titleName = pdfName;
//        pdfName +=".";
//        pdfName += suffix[suffix.length-1];
//        indexService.renameTo(fileName,pdfName,path);
//
//        Video video = new Video();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createTime = simpleDateFormat.format(new Date());
//        video.setCreateTime(createTime);
//        video.setPath("static/pdf/"+pdfName);
//
//        video.setDescribestatic(describe);
//
//        video.setVideoName(titleName);
//        videoService.addVideo(video);
//        return RestfulJson.isOk("上传成功");
//    }



    @GetMapping("download/{fileName:.+}")
    @ApiOperation("下载文件，需要传递文件的文件名字在访问地址中")
    public ResponseEntity downLoadFile(@PathVariable("fileName") String fileName) throws IOException {
        System.out.println("fileName"+fileName);
        File file = new File(FilePath.path);

        String[] fileName2 = fileName.split("\\.");
        String path = FilePath.zip;

        if(fileName2[fileName2.length-1].equalsIgnoreCase("pdf")){
          path = FilePath.pdf;
        }



        File zipFile = new File(file.getAbsolutePath()+path+fileName);

        HttpHeaders headers = new HttpHeaders();
        //二进制流数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //通知浏览器以attachment(下载方式)下载文件，文件名称为指定名称
        //headers.setContentDispositionFormData("attachment",fileName);

        headers.setContentDispositionFormData("attachment", fileName=java.net.URLEncoder.encode(fileName, "UTF-8"));
        byte[] bytes = FileUtils.readFileToByteArray(zipFile);
        return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
    }



}
