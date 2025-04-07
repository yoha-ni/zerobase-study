package dev.yoha_ni.study.one_month.week4.day4;

public class PersonRequest {
    private String name;
    private int age;
    private String address;


    public PersonRequest(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String printDisplay(){

        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
