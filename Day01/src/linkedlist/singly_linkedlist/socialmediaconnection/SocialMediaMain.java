package linkedlist.singly_linkedlist.socialmediaconnection;

public class SocialMediaMain {
    public static void main(String[] args) {
        SocialMediaConnection manager = new SocialMediaConnection();

        // Adding sample users
        manager.addUser(1, "John", 25);
        manager.addUser(2, "Jack", 30);
        manager.addUser(3, "Francisco", 20);

        // Adding friend connections
        manager.addFriendConnection(1, 2);
        manager.addFriendConnection(1, 3);

        // Displaying all users
        System.out.println("All Users : ");
        manager.displayAllUsers();

        // Displaying friends of any specific user
        System.out.println("\nFriends of User 1 : ");
        manager.displayFriends(1);

        // get mutual friends between two users
        System.out.println("\nMutual Friends between User 1 and User 2 : ");
        manager.findMutualFriends(1, 2);

        // Searching for a user
        System.out.println("\nSearch for User with Name 'Jack' : ");
        manager.searchUser("Jack");

        // Counts friends for each user
        System.out.println("\nCount Friends for Each User : ");
        manager.countFriends();

        // Removing a friend connection
        System.out.println("\nRemoving Friend Connection between User 1 and User 2 : ");
        manager.removeFriendConnection(1, 2);
        manager.displayAllUsers();
    }
}
