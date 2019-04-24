package com.itlap;

import com.itlap.model.VieToEng;
import com.itlap.repository.VieToEngRepository;
import com.itlap.service.ReadFiles;
import com.itlap.service.impl.VieToEngService;
import com.itlap.service.inter.VieToEngServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {


    @Autowired
    ReadFiles readFiles;

    @Autowired
    VieToEngRepository vieToEngRepository;

    @Autowired
    VieToEngService vieToEngService;

    public static void main (String[] args) {
        SpringApplication.run(JpaApplication.class);
    }
    public void run(String... args) throws Exception {

//        Map<String, String> dict = readFiles.readFile("C:\\Java\\Project\\ITlap\\BTVN_HuyNQ12\\test.txt");
//        for(Map.Entry<String, String> entry: dict.entrySet()){
//            vieToEngService.insertVieToEng(entry.getKey(),entry.getValue());
//        }
//        vieToEngService.insertVieToEng("ha","hehe");
        List<VieToEng> result = vieToEngService.findByVie("A", 0,10);

        for (VieToEng i :
                result) {
            System.out.println(i.getVie() +":"+i.getEng());
        }

    }
}
