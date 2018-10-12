package com.venus.beauty.service.impl;

import com.venus.beauty.entity.BaseData;
import com.venus.beauty.entity.TbVisit;
import com.venus.beauty.entity.User;
import com.venus.beauty.entity.UserMapper;
import com.venus.beauty.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Override
    public String login(String username, String password) {
        List<User> list = jdbcTemplate.query("select * from user where username = ?",new Object[]{username},new BeanPropertyRowMapper<>(User.class));
        if (list != null && list.size() > 0){
            User user  = list.get(0);
            if (user.getPassword().equals(password))
                return "login";
        }
        return "fail";
    }

    @Override
    public List<User> queryAllUser() {
      return  mapper.selectList(null);
    }

    @Override
    public void visitDemo(HttpServletRequest request) {
        String ip = getIpAddr(request);
        String sql = "select * from BASE_DATA where BASE_ID = ?";
        BaseData  baseData = jdbcTemplate.query(sql,new Object[]{1},new BeanPropertyRowMapper<>(BaseData.class)).get(0);
        int addNum = baseData.getVisitNumber().intValue() + 1;
        String addsql = "UPDATE BASE_DATA set VISIT_NUMBER = ? WHERE BASE_ID = ? ";
        int addresult = jdbcTemplate.update(addsql,new Object[]{addNum,1});
        logger.info("addresult === 1是成功 0是失败" + addresult);

        TbVisit tbVisit = new TbVisit();
        tbVisit.setVisitId(UUID.randomUUID().toString());
        tbVisit.setVisitIp(ip);
        tbVisit.setVisitRemark("该ip是第"+addNum+"个访问此页面的人");
        String tvsql =  "insert into TB_VISIT values(?,?,?)";
        int insertResult = jdbcTemplate.update(tvsql,new Object[]{tbVisit.getVisitId(),tbVisit.getVisitIp(),tbVisit.getVisitRemark()});
        logger.info("insertResult === 1是成功 0是失败" + insertResult);
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
