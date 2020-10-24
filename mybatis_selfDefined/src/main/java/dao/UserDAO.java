package dao;

import domain.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
}
