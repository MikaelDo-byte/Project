package org.example;
import java.util.*;
public class Task1 {


        public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            List<Integer> path = new ArrayList<>();
            int currentIndex = 0;

            for (int i = 0; i < n; i++) {
                path.add(currentIndex + 1);
                currentIndex = (currentIndex + m - 1) % n;
            }

            for (int num : path) {
                System.out.print(num);
            }
        }


}
