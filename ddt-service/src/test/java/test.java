
import com.diuut.ddt.application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

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

    @Test
    public void DreamPoint() {
        String[] redList={"01","02","03","04","05","06","07"};
        String[] blueList={"10","11"};
        String[] newList={};
        String blueBall="";
        for (int i = 0; i < blueList.length; i++) {
            blueBall=blueList[i];
            StringBuilder redBall=new StringBuilder();
            for (int x = 0; x < redList.length; x++) {
                System.out.println();
            }
        }
    }

    private void pointDD(String[] list){
        if (list!=null) {

        }
    }



}
