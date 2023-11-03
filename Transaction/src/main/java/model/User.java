package model;

public class User {
    private int userId;
    private String userName;
    private int age;
    private String nation;

    public User(int userId, String userName, int age, String nation) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.nation = nation;
    }

    public User(String userName, int age, String nation) {
        this.userName = userName;
        this.age = age;
        this.nation = nation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }
}