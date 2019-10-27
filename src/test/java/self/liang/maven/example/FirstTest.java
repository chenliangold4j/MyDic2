package self.liang.maven.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class FirstTest {
    @Test
    public void testSayHello(){

        HelloMaven helloMaven = new HelloMaven();
        String result  = helloMaven.sayHello();
        assertEquals("Hello maven",result);
    }

}
