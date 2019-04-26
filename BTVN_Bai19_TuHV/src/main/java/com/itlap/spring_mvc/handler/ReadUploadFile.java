package com.itlap.spring_mvc.handler;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReadUploadFile {
    private Map<String, String> dict = new HashMap<>();

    public Map ReadUploadFile(BufferedReader br) {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                String key = line.split(":")[0].trim();
                try {
                    String value = line.split(":")[1].trim();
                    dict.put(key, value);
                } catch (ArrayIndexOutOfBoundsException e) {
                    dict.put(key, "");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dict;
    }
}

