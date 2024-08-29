package org.example;
import java.io.*;
public class Task2 {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: java org.example.Task2 <circleFile> <pointsFile>");
            System.exit(1);
        }

        BufferedReader circleReader = new BufferedReader(new FileReader(args[0]));
        BufferedReader pointsReader = new BufferedReader(new FileReader(args[1]));

        String[] centerData = circleReader.readLine().split(" ");
        double centerX = Double.parseDouble(centerData[0]);
        double centerY = Double.parseDouble(centerData[1]);
        double radius = Double.parseDouble(circleReader.readLine());

        String point;
        while ((point = pointsReader.readLine()) != null) {
            String[] pointData = point.split(" ");
            double x = Double.parseDouble(pointData[0]);
            double y = Double.parseDouble(pointData[1]);

            double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

            if (distance < radius) {
                System.out.println(1);
            } else if (distance == radius) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }

        circleReader.close();
        pointsReader.close();
    }
}
