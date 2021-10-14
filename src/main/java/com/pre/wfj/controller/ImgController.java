package com.pre.wfj.controller;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.pre.wfj.bean.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/files")
public class ImgController {

    public static final String ip = "http://localhost:7777";
    @RequestMapping("/upload")
    public Result<?> upload(MultipartFile file){
        //得到文件名
          String originalFilename  =  file.getOriginalFilename();
          // 定义文件的唯一标识
         String flag = IdUtil.fastSimpleUUID();
        //资源路径名
        String rootFilePath = System.getProperty("user.dir")+"/src/main/resources/file/"+flag+"_"+originalFilename;
        //将传入的文件写入存放文件的地方
        try {
            FileUtil.writeBytes(file.getBytes(),rootFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回一个文件资源的ip地址
        return Result.success(ip+"/files/"+flag);

    }
    @RequestMapping("/{flag}")
    public void getFiles( @PathVariable String flag, HttpServletResponse response){
        OutputStream os;  //新建一个输出流对象
        String basePath = System.getProperty("user.dir")+"/src/main/resources/file/";  //文件的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);    //获取所有的文件名称
        String fileName = fileNames.stream().filter(name->name.contains(flag)).findAny().orElse("");  //找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)){
                response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
                response.setContentType("application/octer-stream");
                byte[] bytes = FileUtil.readBytes(basePath+fileName);   //读取文件的路径读取文件字节流
                os = response.getOutputStream();    //通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
        }
    }
}
