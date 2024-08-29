package org.example;
import java.io.*;
import java.util.*;
public class Task4 {



        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            List<Integer> nums = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                nums.add(Integer.parseInt(line));
            }

            Collections.sort(nums);
            int median = nums.get(nums.size() / 2);
            int steps = 0;

            for (int num : nums) {
                steps += Math.abs(num - median);
            }

            System.out.println(steps);
        }



}
