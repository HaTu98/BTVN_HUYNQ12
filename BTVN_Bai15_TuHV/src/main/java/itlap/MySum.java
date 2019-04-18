package itlap;

import org.springframework.stereotype.Component;

@Component
public class MySum {
    public String sum(String first, String second) {
        try {
            return Integer.toString(Integer.parseInt(first) + Integer.parseInt(second));
        } catch (NumberFormatException e) {
        }
        return "";
    }
}
