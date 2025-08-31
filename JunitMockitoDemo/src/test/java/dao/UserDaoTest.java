package dao;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserDaoTest {
    // Mock all these attributes: Connection, PreparedStatement, ResultSet
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private UserDao userDao;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        userDao = new UserDao();

        DatabaseConnection.connection = mockConnection;
    }

    @Test
    void testInsertUser() throws Exception {
        User testUser = new User("Saber", "saber@gmail.com");
        when(mockConnection.prepareStatement(anyString(), anyInt())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1);

        userDao.insertUser(testUser);

        // Asserts
        verify(mockPreparedStatement).setString(1, "Saber");
//        verify(mockPreparedStatement).setString(2, "Saber");
        verify(mockPreparedStatement).executeUpdate();
        assertEquals(1, testUser.getId());
    }

    @Test
    void testGetUser() throws Exception {
        User user;
        UserDao userDao = new UserDao();

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("Saber");
        when(mockResultSet.getString("email")).thenReturn("Saber@gmail.com");

        user = userDao.getUser(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("Saber", user.getName());
        assertEquals("Saber@gmail.com", user.getEmail());
    }
}
