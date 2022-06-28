
import com.diuut.ddt.app;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Diuut
 * @Date 2020/9/8  16:32
 */
@SpringBootTest(classes = app.class)
@Slf4j
public class test {
    @Test
    public void test1(){
        log.info("hello world");
    }
}
