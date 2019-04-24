package com.itlap.service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReadFiles {

    private Map<String, String> dict = new HashMap<>();
    public Map readFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String key = line.split(":")[0];
                try {
                    String value = line.split(":")[1];
                    dict.put(key, value);
                } catch (ArrayIndexOutOfBoundsException e ) {
                    dict.put(key, "");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dict;
    }
}
