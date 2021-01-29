package com.hegong.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.util.List;
import java.util.UUID;


/**
 * @author 14767
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //使用fileupload组件完成上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        System.out.println(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //解析request对象获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断，判断当前的item对象是否是上传的文件项
            if (item.isFormField()){
                //说明是一个普通的表单项
            }else {
                //说明是一个上传文件项
                //获取到上传文件的名称
                String filename = item.getName();
                //把文件的名称设置为唯一的值，uuid
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid+"_"+filename;
                //完成文件上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload(HttpServletRequest request,MultipartFile upload) throws IOException {
        //设置上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径的文件是否存在，不存在则创建
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取文件名称
        String filename = upload.getOriginalFilename();
        //保证上传后的文件id唯一
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        return "success";
    }


    @RequestMapping("/fileupload3")
    public String fileupload(MultipartFile upload) throws IOException {
        System.out.println("跨服务器上传");
        //定义上传服务器的路径
        String path = "http://localhost:9090/uploads/";
        //获取文件名称
        String filename = upload.getOriginalFilename();
        //保证上传后的文件id唯一
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;

        //完成跨服务器的文件上传
        //创建一个客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource resource = client.resource(path + filename);
        //上传图片
        resource.put(upload.getBytes());
        return "success";
    }
}
