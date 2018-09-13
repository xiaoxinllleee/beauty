package com.venus.beauty.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author lx
 * @time 2018/9/10
 */
public interface ImpService {
    Map<String,Object> batchImport(String fileName,MultipartFile file) throws Exception;
}
