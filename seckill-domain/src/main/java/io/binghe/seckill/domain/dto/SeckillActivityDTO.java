package io.binghe.seckill.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YouChuande
 */
public class SeckillActivityDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    private String activityName;

    //活动开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date startTime;
    //活动结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date endTime;
    //    0:已发布 1:上线 -1 下线
    private Integer status;

    private String activityDesc;


    public Long getId() {
        return id;
    }

    public SeckillActivityDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getActivityName() {
        return activityName;
    }

    public SeckillActivityDTO setActivityName(String activityName) {
        this.activityName = activityName;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public SeckillActivityDTO setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public SeckillActivityDTO setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SeckillActivityDTO setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public SeckillActivityDTO setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
        return this;
    }
}
