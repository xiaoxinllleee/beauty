package com.venus.beauty.service.impl;

import com.venus.beauty.entity.TbFasiAwardInfo;
import com.venus.beauty.service.ImpService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author lx
 * @time 2018/9/10
 */
@Service
public class ImpServiceImpl implements ImpService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Map<String, Object> batchImport(String fileName, MultipartFile file) throws Exception{
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);

        int count = 0;
        for (int r = 1; r <= sheet.getLastRowNum(); r++){
            Row row = sheet.getRow(r);
            if (row == null){
                throw new Exception("row为空");
            }

            //姓名 学号 类型 获奖等级 获奖年份
            String name = null;
            String xh = null;
            String add = null;
            String lever = null;
            try {
                name = row.getCell(0).getStringCellValue();
                if(name == null || name.isEmpty()){
                    throw new Exception("导入失败(第"+(r+1)+"行,姓名未填写)");
                }

                if(row.getCell(1)!=null){
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                     xh = row.getCell(1).getStringCellValue();
                }else {
                    throw new Exception("导入失败(第"+(r+1)+"行,学号未填写)");
                }


                add = row.getCell(2).getStringCellValue();
                if(add==null){
                    throw new Exception("导入失败(第"+(r+1)+"行,获奖类型未填写)");
                }

                lever = row.getCell(3).getStringCellValue();
                if(lever==null){
                    throw new Exception("导入失败(第"+(r+1)+"行,获奖等级未填写)");
                }


            String years =  row.getCell(4).getStringCellValue();
            if (years == null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                years = sdf.format(new Date());
            }

            TbFasiAwardInfo tbFasiAwardInfo = new TbFasiAwardInfo();
            tbFasiAwardInfo.setId(UUID.randomUUID().toString());
            tbFasiAwardInfo.setAwardName(fileName.substring(0,fileName.indexOf(".")));
            tbFasiAwardInfo.setAwardTerm(years);
            tbFasiAwardInfo.setAwardLevel(add);
            tbFasiAwardInfo.setAwardRanking(lever);
            tbFasiAwardInfo.setAwardUserName(name);
            tbFasiAwardInfo.setAwardUserSfzh(xh);
            String sql ="insert into TB_FASI_AWARD_INFO values(?,?,?,?,?,?,?)";
            int insertResult = jdbcTemplate.update(sql,new Object[]{
                    UUID.randomUUID().toString(),fileName.substring(0,fileName.indexOf(".")),years,add,lever,name,xh
            });
            if (insertResult == 1){
                count ++;
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","本次导入"+sheet.getLastRowNum()+"条获奖信息,其中成功导入"+count+"条学生获奖信息，失败"+(sheet.getLastRowNum()-count)+"条信息");
        return map;

    }
}
