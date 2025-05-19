package ru.otus.java.basic.homeworks;

public class Application {
    public static void main(String[] args) {
         String a = "54.6";
         try {
             int bbb = Integer.parseInt(a);
             System.out.println(bbb);
         }
         catch (NumberFormatException e){
             System.out.println("jib,rf");
         }

    }
}