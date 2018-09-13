package com.venus.beauty.controller;

import com.venus.beauty.service.ImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lx
 * @time 2018/9/10
 */
@Controller
public class impController {

    @Autowired
    private ImpService service;

    @RequestMapping("/imp")
    public String getImp(){return "imp";}

    @RequestMapping("/batchImport")
    @ResponseBody
    public Map<String, Object> batchImport(@RequestParam("filename") MultipartFile file){
        Map<String, Object> map = new HashMap<>();
        String fileName = file.getOriginalFilename();
        try {
            map = service.batchImport(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
