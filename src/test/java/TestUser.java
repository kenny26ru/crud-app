import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import web.config.HibernateConfig;
import org.junit.Test;
import web.model.User;
import web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {HibernateConfig.class})
public class TestUser {
    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        userService.add(new User("Rol",15));
        userService.add(new User("Nol",14));
        userService.add(new User("Pol",13));

        System.out.println(userService.allUsers());
    }

    @Test
    public void allUsers() {
        System.out.println(userService.allUsers());
        System.out.println(userService.allUsers().size());
    }
}
