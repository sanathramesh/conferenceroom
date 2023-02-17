package database;

import model.User;

import java.util.ArrayList;
import java.util.List;

import static util.StringValidator.stringValidator;

public class Users {
    private List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public void addUser(String userId, String name) {
        if(stringValidator(userId, "userId") && stringValidator(name, "name")) {
            User user = new User(userId, name);
            this.users.add(user);
        }
    }

    public List<User> getUsers(){
        return this.users;
    }
}
