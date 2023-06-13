package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class task1{
    public static int mul(int i){
        return i*5;
    }

    public static float div(float i){
        return i/5;
    }
    public static void main(String[] args) {
         Integer[] arr={10,12,14,89,3,5,3,9,6,5};
         Integer[] arr2={23,34,6,67,4,3,77,3,5,9};
        LinkedList<Integer> ll1 = new LinkedList<>(Arrays.asList(arr));
        LinkedList<Integer> ll2= new LinkedList<>(Arrays.asList(arr2));
        for (Integer i:ll1) {
            if(ll2.contains(i)){
                System.out.println("data exist so no mul and div");
            }else if (!ll2.contains(i)) {
                System.out.println("multiply");
                System.out.println(mul(i));
                System.out.println("divison");
                System.out.println(div(i));
            }
        }

    }
}
