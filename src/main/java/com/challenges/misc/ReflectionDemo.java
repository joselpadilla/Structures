package com.challenges.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    private String name;
    public int id;

    public ReflectionDemo() {
        this.name = "default";
        this.id = 0;
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("com.challenges.misc.ReflectionDemo");

            // Get all declared fields
            System.out.println("--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field Name: " + field.getName() + ", Type: " + field.getType());
            }

            // Get all declared methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}