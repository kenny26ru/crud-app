package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.create(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.update(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        User response = userRepository.read(id);
        return response;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        List<User> users = userRepository.allUsers();
        return users;
    }
}
