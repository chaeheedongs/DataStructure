package b_class_pointer;

import b_class_pointer.dto.User;

public class ClassMemory {

    public static void main(String[] args) {

        User user1 = null;
        User user2 = null;
        User user3 = null;

        printHash(user1);
        printHash(user2);
        printHash(user3);

//        List<User> userList1 = Arrays.asList(user1, user2, user3);
//        userList1.forEach(ClassMemory::printHash);



        user1 = new User("foo");
        user2 = new User("bar");
        user3 = new User("baz");

        printHash(user1);
        printHash(user2);
        printHash(user3);

//        List<User> userList2 = Arrays.asList(user1, user2, user3);
//        userList2.forEach(ClassMemory::printHash);
    }

    public static <T> void printHash(T t) {

        try {
            int hashCode = t.hashCode();
            String className = t.getClass().getSimpleName();

            System.out.println();
            System.out.println("print hash code");
            System.out.println("class name is " + className);
            System.out.println("-------------------------");
            System.out.println(hashCode);
        }
        catch (NullPointerException e) {
            System.out.println("해당 클래스는 아직 메모리에 올라가지 않았습니다.");
        }
    }
}
