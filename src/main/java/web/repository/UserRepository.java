package web.repository;

import web.model.User;
import java.util.List;


public interface UserRepository {
    User create(User user);
    User read(Long id);
    User update(User user);
    void delete(User user);
    List<User> allUsers();
}
