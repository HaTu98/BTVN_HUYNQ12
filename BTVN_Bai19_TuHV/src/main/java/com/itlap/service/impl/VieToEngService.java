package com.itlap.service.impl;

import com.itlap.model.VieToEng;
import com.itlap.repository.VieToEngRepository;
import com.itlap.service.inter.VieToEngServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VieToEngService implements VieToEngServiceInterface {

    @Autowired
    VieToEngRepository vieToEngRepository;

    @Override
    public List<VieToEng> findByVie(String vie, int pageIndex, int pageSize) {
        return vieToEngRepository.findByVie("Ai", new PageRequest(0,10)).getContent();
    }

    @Override
    @Transactional
    public void insertVieToEng(String vie, String eng) {
        vieToEngRepository.insertVieToEng(vie,eng);
    }
}
