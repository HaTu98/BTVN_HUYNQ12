package com.topica.vn.itlap;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Handler {

    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").toUpperCase().replace('Đ', 'D');
    }
}