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
            String line = br.readLine();
            if (!line.contains("@")) {
                while (line != null) {
                    String key = line.split(":")[0].trim();
                    try {
                        String value = line.split(":")[1].trim();
                        dict.put(key, value);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        dict.put(key, "");
                    }
                    line = br.readLine();
                }
            } else {
                String key = "", value = "";
                while (line != null) {
                    if (line.contains("@")) {
                        value = "";
                        String ar[] = line.split("/");
                        if (ar.length > 1) {
                            key = ar[0].substring(1, ar[0].length()).trim();
                            value = ar[1];
                        }
                    } else {
                        value += "\n"+ line;
                    }

                    line = br.readLine();
                    //System.out.println(key + " : " + value);
                    System.out.println(line);
                    if(line != null) {
                        if (line.contains("@") && key != "") {
                            dict.put(key, value);
                        }
                    }
                }
                if (key != "" && value != "") {
                    dict.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dict;
    }
}

