package io.binghe.seckill.application.service.impl;

import io.binghe.seckill.application.service.SeckillActivityService;
import io.binghe.seckill.domain.code.HttpCode;
import io.binghe.seckill.domain.dto.SeckillActivityDTO;
import io.binghe.seckill.domain.enums.SeckillActivityStatus;
import io.binghe.seckill.domain.exception.SeckillException;
import io.binghe.seckill.domain.model.SeckillActivity;
import io.binghe.seckill.domain.repository.SeckillActivityRepository;
import io.binghe.seckill.infrastructure.utils.id.SnowFlakeFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author YouChuande
 */
@Service
public class SeckillActivityServiceImpl implements SeckillActivityService {

    @Resource
    private SeckillActivityRepository seckillActivityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSeckillActivityDTO(SeckillActivityDTO seckillActivityDTO) {
        if (seckillActivityDTO == null) {
            throw new SeckillException(HttpCode.PARAMS_INVALID);
        }
        SeckillActivity seckillActivity = new SeckillActivity();
        BeanUtils.copyProperties(seckillActivityDTO, seckillActivity);
        seckillActivity.setId(SnowFlakeFactory.getSnowFlakeFromCache().nextId());
        seckillActivity.setStatus(SeckillActivityStatus.PUBLISHED.getCode());
        seckillActivityRepository.saveSeckillActivity(seckillActivity);
    }

    @Override
    public List<SeckillActivity> getSeckillActivityList(Integer status) {
        return seckillActivityRepository.getSeckillActivityList(status);
    }

    @Override
    public List<SeckillActivity> getSeckillActivityListBetweenStartTimeAndEndTime(Date currentTime, Integer status) {
        return seckillActivityRepository.getSeckillActivityListBetweenStartTimeAndEndTime(currentTime, status);
    }

    @Override
    public SeckillActivity getSeckillActivityById(Long id) {
        return seckillActivityRepository.getSeckillActivityById(id);
    }

    @Override
    public int updateStatus(Integer status, Long id) {
        return seckillActivityRepository.updateStatus(status, id);
    }
}
