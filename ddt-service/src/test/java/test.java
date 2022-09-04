
import com.diuut.ddt.application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Diuut
 * @Date 2020/9/8  16:32
 */
@SpringBootTest(classes = application.class)
@Slf4j
public class test {
    @Test
    public void test1() {
        log.info("hello world");
    }

    @Test
    public void test2() {
       String test="123456";
        System.out.println(test.indexOf("87"));
    }


}
