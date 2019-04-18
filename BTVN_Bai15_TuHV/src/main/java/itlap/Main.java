package itlap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configApp.xml");
        MySum mySum = (MySum) context.getBean("mySum");

        System.out.println("Result : " + mySum.sum("0", "2"));
        System.out.println("Result : " + mySum.sum("1", "a"));
        System.out.println("Result : " + mySum.sum("a", "b"));

    }
}
