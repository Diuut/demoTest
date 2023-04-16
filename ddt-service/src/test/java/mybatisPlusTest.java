
import com.diuut.ddt.application;
import com.diuut.ddt.mapper.PersonMapper;
import com.diuut.ddt.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

/**
 * @Author Diuut
 * @Date 2020/9/8  16:32
 */
@SpringBootTest(classes = application.class)
@Slf4j
@RunWith(SpringRunner.class)
public class mybatisPlusTest {
    @Autowired
    private PersonMapper personMapper;


    @Test
    public void testSelectList() {
        List<Person> personList = personMapper.selectList(null);
//        System.out.println(personList.toString());
        personList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        Person person = new Person();
        person.setAge(9);
        person.setName("Stringer");
        person.setEmail("Hao.Zhang@cn.pwc.com");
        int insert = personMapper.insert(person);
        System.out.println("result:"+insert);
        this.testSelectList();
    }

    @Test
    public void testUpdate() {
        Person person = new Person();
        person.setId(3L);
        person.setAge(9);
        person.setName("stinger");
        person.setEmail("Hao.Zhang@cn.pwc.com");
        int insert = personMapper.updateById(person);
        System.out.println("result:"+insert);
        this.testSelectList();
    }

    @Test
    public void testDelete() {
        Person person = new Person();
        person.setId(3L);
        int insert = personMapper.deleteById(person);
        System.out.println("result:"+insert);
        this.testSelectList();
    }



}
