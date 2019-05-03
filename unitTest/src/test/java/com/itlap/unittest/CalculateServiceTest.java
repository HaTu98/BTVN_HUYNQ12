package com.itlap.unittest;

import com.itlap.unittest.service.CalculateService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CalculateServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sumTest1(){
        CalculateService calculateService = new CalculateService();
        int result = calculateService.sum(1,2);
        assertEquals(3,result);
    }

    @Test
    public void divideTest1() throws Exception {
        CalculateService calculateService = new CalculateService();
        try {
            calculateService.divide(1, 0);
            fail("Not throw exception");
        } catch (Exception e) {
            assertThat(e, instanceOf(ArithmeticException.class));
            assertEquals(e.getMessage(), "divide by zer");
        }
    }

    @Test
    public void divideTest2() throws Exception {
        float expect = (float)1/3;
        CalculateService calculateService = new CalculateService();
        float result = (float)calculateService.divide(1,3);

        assertEquals(expect,result,Math.pow(10.0,-23));
    }

    @Test
    public void ptb2Test1() throws Exception{
        CalculateService calculateService = new CalculateService();
        try {
            calculateService.ptb2(1,1,1);
            fail("Not throw exception");
        } catch (Exception e) {
            assertThat(e, instanceOf(ArithmeticException.class));
            assertEquals(e.getMessage(), "vo nghiem");
        }
    }

    @Test
    public void ptb2Test2() throws Exception{
        CalculateService calculateService = new CalculateService();
        try {
            calculateService.ptb2(0,0,0);
            fail("Not throw exception");
        } catch (Exception e) {
            assertThat(e, instanceOf(ArithmeticException.class));
            assertEquals(e.getMessage(), "vo so nghiem");
        }
    }

    @Test
    public void ptb2Test3() {
        CalculateService calculateService = new CalculateService();
        Float exceptd[] = new Float[1];
        exceptd[0]=(float)2;
        assertEquals(exceptd ,calculateService.ptb2(0,1,-2));
    }

    @Test
    public void ptb2Test4() {
        CalculateService calculateService = new CalculateService();
        Float exceptd[] = new Float[2];
        exceptd[0]=(float)1;
        exceptd[1]=(float)1;
        assertEquals(exceptd ,calculateService.ptb2(1,-3,2));
    }

    @Test
    public void ptb2Test5() {
        CalculateService calculateService = new CalculateService();
        Float exceptd[] = new Float[1];
        exceptd[0]=(float)1;
        assertEquals(exceptd ,calculateService.ptb2(1,-2,1));
    }
}
