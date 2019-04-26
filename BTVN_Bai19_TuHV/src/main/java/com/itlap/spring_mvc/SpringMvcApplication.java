package com.itlap.spring_mvc;

//import com.itlap.spring_mvc.handler.ReadFiles;
//import com.itlap.spring_mvc.model.Dictionary;
import com.itlap.spring_mvc.repository.DictionaryRepository;
import com.itlap.spring_mvc.repository.UserRepository;
import com.itlap.spring_mvc.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import java.util.List;
//import java.util.Map;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {
//    @Autowired
//    ReadFiles readFiles;

    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    UserRepository userRepository;

    public static void main (String[] args) {
        SpringApplication.run(SpringMvcApplication.class);
    }
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//        Map<String, String> dict = readFiles.readFile("C:\\Java\\Project\\ITlap\\BTVN_HuyNQ12\\BTVN_Bai19_TuHV\\src\\main\\resources\\dataTest\\vnedict.txt");
//        for(Map.Entry<String, String> entry: dict.entrySet()){
//            dictionaryService.insertDictionary(entry.getKey(),entry.getValue());
//        }
        if(userRepository.findByUsername("hatu") == null) {
            userRepository.insertUser("admin", encoder.encode("admin"), "user");
        }
    }
}

