package com.zelin.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("list")
    @ResponseBody
    public List<String> list(){
        String realPath = request.getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        List<String> files = new ArrayList<>();
        for (File f : file.listFiles()) {
            files.add(f.getName());
        }
        return files;
    }

    @RequestMapping("upload")
    public String upload(MultipartFile file){
        String realname = file.getOriginalFilename();
        if(realname != null && !"".equals(realname)){
            String suffixName = realname.substring(realname.lastIndexOf("."));
            String peffixName = UUID.randomUUID().toString();
            String fileName = peffixName+ suffixName;

            String realPath = request.getServletContext().getRealPath("/upload");
            String name = realPath + File.separator + fileName;

            try {
                file.transferTo(new File(name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "forward:/download.html";
    }

    @RequestMapping(value = "/download",produces="application/octet-stream;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<byte[]> download(String fileName){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        String realPath = request.getServletContext().getRealPath("/upload");
        String fullName = realPath + File.separator + fileName;
        File file = new File(fullName);
        try {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            return new ResponseEntity <byte[]> (bytes,headers,HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
