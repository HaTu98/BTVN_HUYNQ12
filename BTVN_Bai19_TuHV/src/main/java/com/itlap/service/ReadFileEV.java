package com.itlap.service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReadFileEV {

    private Map<String, String> dict = new HashMap<>();
    public Map readFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dict;
    }
}
