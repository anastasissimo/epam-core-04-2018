package com.epam.homework.task21;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task21Impl implements Task21 {
    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> strings;
        try (Stream<String> stream = Files.lines(Paths.get(input.getPath()))) {
            strings = stream.collect(Collectors.toList());
        }
        Collections.reverse(strings);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))){
            for (String s:strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }
        return strings;
    }
}
