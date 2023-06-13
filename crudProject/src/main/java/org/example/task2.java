package org.example;

import java.time.LocalDate;
import java.util.LinkedList;

public class task2 {
    public static LocalDate add(int count){
//        LinkedList<LocalDate> ll= new LinkedList<>();
        return java.time.LocalDate.now().minusYears(count).minusMonths(count);

    }
    public static void main(String[] args) {
        LinkedList<LocalDate> ll=new LinkedList<>();
        task2 t=new task2();
        for(int i=1;i<=10;i++){
            LocalDate d=t.add(i);
            ll.add(d);
        }
//        System.out.println(ll);
        LocalDate currdate=java.time.LocalDate.now();
        for (LocalDate d:ll) {
            if(d.getMonth().compareTo(currdate.getMonth())>0){
                d.minusYears(1);
                System.out.println("this dates month is more than current date month ");
                System.out.println(currdate);
            } else if (d.getMonth().compareTo(currdate.getMonth())<0) {
                d.minusYears(1);
                System.out.println("this dates month is less than current date month ");
                System.out.println(currdate.minusYears(1));//2022-05
            } else if (d.getMonth().compareTo(currdate.getMonth())== 0) {
                d.minusMonths(4);
                System.out.println("this dates month is same as current date month ");
                System.out.println(currdate.minusMonths(4));//2023-01
            }
        }
    }
}



















