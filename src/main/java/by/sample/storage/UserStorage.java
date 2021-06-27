package by.sample.storage;

import by.sample.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {

    List<User> users = new ArrayList<>();

    public void save(User user) {
        if (user.getName().equals("admin")) {
            throw new NullPointerException("User Admin");
        }
        users.add(user);
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void updateName(String newName, String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                user.setName(newName);
            }
        }
    }

    public void updatePassword(String newPassword, String login) {
        for (User user : users) {
            if (user.getLogin().equals(newPassword)) {
                user.setPassword(newPassword);
            }
        }
    }
}
