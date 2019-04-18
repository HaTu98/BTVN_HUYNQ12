package itlap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAop {
    private boolean isNumber;

    @Before("execution(* itlap.MySum.sum(..))")
    public void beforeSum(JoinPoint joinPoint) {
        String num1 = (String) joinPoint.getArgs()[0];
        String num2 = (String) joinPoint.getArgs()[1];
        if(num1.matches("-?\\d+") && num2.matches("-?\\d+")){
            this.isNumber = true;
        } else {
            this.isNumber = false;
        }
    }

    @Around("execution(* itlap.MySum.sum(..))")
    public String beforeReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = joinPoint.proceed();
        if (this.isNumber)
            return obj.toString();
        return "N/A";
    }
}
