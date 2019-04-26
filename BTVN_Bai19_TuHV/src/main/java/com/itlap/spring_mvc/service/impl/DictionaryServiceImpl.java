package com.itlap.spring_mvc.service.impl;

import com.itlap.spring_mvc.model.Dictionary;
import com.itlap.spring_mvc.repository.DictionaryRepository;
import com.itlap.spring_mvc.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public List<Dictionary> findByWord(String word, int pageIndex, int pageSize) {
        return dictionaryRepository.findByWord(word, new PageRequest(pageIndex,pageSize)).getContent();
    }

    @Override
    public Dictionary findByWord(String word) {
        Dictionary dictionary;
        try{
            dictionary = dictionaryRepository.findByWord(word);
        } catch (Exception e){
            dictionary = null;
        }
        return dictionary;
    }

    @Override
    @Transactional
    public void insertDictionary(String word, String mean) {
        dictionaryRepository.insertDictionary(word,mean);
    }
}
