package com.epam.homework.task21;

import java.io.*;
import java.util.*;

public class TaskImplementation implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> strings = new ArrayList<>();
            try (Scanner scanner = new Scanner(new FileInputStream(input))) {
                while (scanner.hasNextLine()) {
                    strings.add(scanner.nextLine());
                }
            }
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(output))) {
            for (int i = strings.size()-1; i >= 0; i--) {
                outputStream.write(strings.get(i));
                outputStream.newLine();
            }
        }
        return strings;
    }
}