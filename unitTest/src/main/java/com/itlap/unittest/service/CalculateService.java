package com.itlap.unittest.service;

public class CalculateService {
    public int sum (int a, int b){
        return a+b;
    }

    public int multiple(int a, int b) {
        return (a*b);
    }

    public float divide(int a, int b){
        if(b==0){
            throw new ArithmeticException("divide by zero");
        }
        return (float)a/b;
    }

    public Float[] ptb2(int a, int b, int c){
        if(a == 0) {
            if(b == 0){
                if(c == 0) {
                    throw new ArithmeticException("vo so nghiem");
                } else {
                    throw new ArithmeticException("vo nghiem");
                }
            }else {
                Float result[] = new Float[1];
                result[0]= (float)(-c/b);
                return result;
            }
        } else {
            Float delta = (float)((b*b)-(4*a*c));
            if(delta < 0) {
                throw new ArithmeticException("vo nghiem");
            }
            if(delta == 0) {
                Float result[] = new Float[1];
                result[0] = (float)(-b/(2*a));
                return result;
            }
            if(delta > 0){
                Float result[] = new Float[2];
                result[0] = (float)((-b-Math.sqrt(delta))/(2*a));
                result[1] = (float)((-b+Math.sqrt(delta))/(2*a));
                return result;
            }
        }
        return  null;
    }
}
