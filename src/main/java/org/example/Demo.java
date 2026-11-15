package org.example;

@FunctionalInterface
public interface Demo {

    void test();

    static void show(){
        System.out.println("show");
    }

    default void print(){
        System.out.println("print");
    }

}
