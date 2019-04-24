package com.itlap.service.inter;

import com.itlap.model.VieToEng;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VieToEngServiceInterface {
    List<VieToEng> findByVie (String vie, int pageIndex, int pageSize);
    void insertVieToEng(String vie,String eng);
}
