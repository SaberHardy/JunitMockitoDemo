package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(User user) throws SQLException {
        try {
            this.userDao.insertUser(user);
            System.out.println("User created: " + user);
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    public User getUser(int id) {
        try {
            return this.userDao.getUser(id);
        } catch (SQLException e) {
            System.err.println("Error getting user: " + e.getMessage());
            return null;
        }
    }

    public List<User> getAllUsers() {
        try {
            return this.userDao.getAllUsers();
        } catch (SQLException e) {
            System.err.println("Error getting users: " + e.getMessage());
            return List.of(); // Return empty list on error
        }
    }

    public void updateUser(User user) {
        try {
            if (this.userDao.updateUser(user)) {
                System.out.println("User updated: " + user);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(int id) {
        try {
            if (this.userDao.deleteUser(id)) {
                System.out.println("User deleted with ID: " + id);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }
}