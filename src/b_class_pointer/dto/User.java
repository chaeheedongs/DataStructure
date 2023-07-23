package b_class_pointer.dto;

import java.util.Objects;

public class User {

    private String name;
    private GENDER gender;
    private int age;
    private String email;
    private String address;

    public User() { }

    public User(String name) {
        this(name, null, 0, null, null);
    }

    public User(String name, GENDER gender, int age, String email, String address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && gender == user.gender && Objects.equals(email, user.email) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, email, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
