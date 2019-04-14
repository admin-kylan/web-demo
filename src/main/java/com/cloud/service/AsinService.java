package com.cloud.service;

import com.cloud.entity.AsinEntity;
import com.cloud.repository.AsinEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * className AsinService
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 18:54
 */
@Service
public class AsinService {

    @Autowired
    private AsinEntityRepository asinEntityRepository;

    public void saveOrUpdate(AsinEntity asinEntity){
        System.out.println(asinEntity);
        asinEntityRepository.save(asinEntity);
    }
}
