package com.venus.beauty.mapper;

import com.venus.beauty.entity.Scheduled;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lx
 * @since 2018-10-16
 */
public interface ScheduledMapper extends BaseMapper<Scheduled> {

    List<Scheduled> getAllSche();
}
