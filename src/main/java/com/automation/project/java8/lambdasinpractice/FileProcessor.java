package com.automation.project.java8.lambdasinpractice;

import java.io.*;

public class FileProcessor {
    public static String processFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/data.txt"))) {
            return bufferedReader.readLine();
        }
    }
    public static String processFile(FileProc fileProc) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(System.getProperty("user.dir") + "/src/main/resources/data.txt"))) {
            return fileProc.process(bufferedReader);
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(processFile());
        System.out.println("Fetching one line from file...");
        System.out.println(processFile((BufferedReader br)->br.readLine()));
        System.out.println("Fetching two lines from file...");
        System.out.println(processFile((BufferedReader br)->br.readLine()+"\n"+br.readLine()));
    }
}
