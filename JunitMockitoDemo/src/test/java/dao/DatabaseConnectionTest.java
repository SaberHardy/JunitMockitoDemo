package dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DatabaseConnectionTest {
    private Connection connection;

    @BeforeEach
    void setUp() throws Exception {
        connection = DatabaseConnection.getConnection();
    }

    @AfterEach
    void tearDown() throws Exception {
        DatabaseConnection.closeConnection();
    }

    @Test
    void testConnectionIsValid() throws Exception {
        assertFalse(connection.isClosed());
        assertTrue(connection.isValid(2));
    }
}
