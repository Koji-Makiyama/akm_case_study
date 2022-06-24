package akm_case_study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import akm_case_study.AkmCaseStudyApplication;
import akm_case_study.model.User;
import akm_case_study.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AkmCaseStudyApplication.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NewTestFile {
    
    @Autowired
    UserService userService;
    
    @Test
    void confirmUserLength() {
        User user = userService.findByEmail("abc@gmail.com");
        System.out.println(user.toString());
        String fullName = user.getFirstName() + " " + user.getLastName();
        System.out.println(fullName);
        assertEquals(fullName, "A B");
    }

}