package com.venus.beauty.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2018-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SCHEDULED")
public class Scheduled implements Serializable {

    private static final long serialVersionUID = 1L;

    private String timetask;

    private String remark;

    private String taskId;

    private String useUser;


}
