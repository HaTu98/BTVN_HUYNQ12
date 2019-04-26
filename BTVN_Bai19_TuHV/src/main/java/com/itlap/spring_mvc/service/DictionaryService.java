package com.itlap.spring_mvc.service;

import com.itlap.spring_mvc.model.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DictionaryService {
    List<Dictionary> findByWord (String word, int pageIndex, int pageSize);
    Dictionary findByWord(String word);
    void insertDictionary(String word,String mean);
}
