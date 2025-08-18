import model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // Create users
//         userService.createUser(new User("Alice2", "alice2@example.com"));
//         userService.createUser(new User("Bob2", "bob2@example.com"));
        // Get all users
//         System.out.println("All users:");
//         userService.getAllUsers().forEach(System.out::println);
        //
        // Update user
        // User userToUpdate = userService.getUser(1);
        // if (userToUpdate != null) {
        //    userToUpdate.setEmail("alice.new@example.com");
        //    userService.updateUser(userToUpdate);
        //}

        // Delete user
        // userService.deleteUser(2);

        // Verify final state
        System.out.println("Remaining users:");
        userService.getAllUsers().forEach(System.out::println);
    }
}