package dao;

import model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.UserService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserDao mockUserDao;
    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUser_Success() throws SQLException {
        User testUser = new User("Saber_4", "saber_4@gmail.com");
        doNothing().when(mockUserDao).insertUser(any(User.class));

        userService.createUser(testUser);

        verify(mockUserDao).insertUser(testUser);
    }

    @Test
    void testGetUser() throws SQLException {
        // Arrange
        when(mockUserDao.getAllUsers()).thenReturn(Collections.emptyList());

        // Act
        List<User> result = userService.getAllUsers();

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void getUser_NotFound() throws SQLException {
        // Arrange
        when(mockUserDao.getUser(908)).thenReturn(null);

        // Act
        User result = userService.getUser(908);

        // Assert
        assertNull(result);
    }
}
