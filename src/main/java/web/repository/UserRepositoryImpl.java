package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User create(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User read(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User update(User user) {
        user = em.merge(user);
        return user;
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public List<User> allUsers() {
        List<User> users = em.createQuery("select u from User u").getResultList();
        return users;
    }
}
