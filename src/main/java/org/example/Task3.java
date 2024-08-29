package org.example;

import com.google.gson.*;
import java.io.*;
import java.nio.file.*;

public class Task3 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java org.example.Task3 <valuesPath> <testsPath> <reportPath>");
            System.exit(1);
        }

        String valuesPath = args[0];
        String testsPath = args[1];
        String reportPath = args[2];

        try {
            JsonObject values = JsonParser.parseReader(new FileReader(valuesPath)).getAsJsonObject();
            JsonObject tests = JsonParser.parseReader(new FileReader(testsPath)).getAsJsonObject();

            fillValues(tests, values);

            Files.write(Paths.get(reportPath), new GsonBuilder().setPrettyPrinting().create().toJson(tests).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillValues(JsonObject tests, JsonObject values) {
        for (String key : tests.keySet()) {
            JsonElement test = tests.get(key);
            if (test.isJsonObject()) {
                JsonObject testObj = test.getAsJsonObject();
                if (testObj.has("value")) {
                    String id = testObj.get("id").getAsString();
                    testObj.add("value", values.get(id));
                }
                fillValues(testObj, values);
            } else if (test.isJsonArray()) {
                for (JsonElement elem : test.getAsJsonArray()) {
                    fillValues(elem.getAsJsonObject(), values);
                }
            }
        }
    }
}
