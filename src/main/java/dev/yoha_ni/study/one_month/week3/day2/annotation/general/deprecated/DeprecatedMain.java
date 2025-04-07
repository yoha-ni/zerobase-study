package dev.yoha_ni.study.one_month.week3.day2.annotation.general.deprecated;

public class DeprecatedMain {
    public static void main(String[] args) {
        OldLibrary oldLibrary = new OldLibrary();
        oldLibrary.printMessage();

        NewLibrary newLibrary = new NewLibrary();
        newLibrary.printMessage();
    }
}
