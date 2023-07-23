package b_class_pointer;

import b_class_pointer.dto.User;

public class CallByReference {

    public static void main(String[] args) {

        User user1 = new User("foo");
        User user2 = new User("bar");

        System.out.println();
        System.out.println("Create User Object And Show Hash Code");
        System.out.println("user1 hash code : " + user1.hashCode());
        System.out.println("user2 hash code : " + user2.hashCode());
        System.out.println("-------------------------------------");
        System.out.println();

        // Call By Reference (Swallow Copy)
        user2 = user1;

        System.out.println();
        System.out.println("Is Sames User Object HashCode?");
        System.out.println("user1 hash code : " + user1.hashCode());
        System.out.println("user2 hash code : " + user2.hashCode());
        System.out.println("user1 name : " + user1.getName());
        System.out.println("user2 name : " + user2.getName());
        System.out.println("-------------------------------------");
        System.out.println();

        user1.setName("ChangeName");

        System.out.println();
        System.out.println("Is Sames User Object Name?");
        System.out.println("user1 name : " + user1.getName());
        System.out.println("user2 name : " + user2.getName());
        System.out.println("-------------------------------------");
        System.out.println();
    }
}
