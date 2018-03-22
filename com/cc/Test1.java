package com.cc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {

  public static void main(String[] args) throws IOException {
    final File folder = new File(args[0]);
    BufferedWriter bw = new BufferedWriter(new FileWriter(args[1], true));
    listFilesForFolder(folder, bw);
    System.out.println("Done");
  }

  public static void listFilesForFolder(final File folder, BufferedWriter bw) throws IOException {
    for (final File fileEntry : folder.listFiles()) {
      if (fileEntry.isDirectory()) {
        listFilesForFolder(fileEntry, bw);
      } else {
        if (fileEntry.getName().endsWith(".pom")) {
          BufferedReader br = new BufferedReader(new FileReader(fileEntry));
          String line;
          while ((line = br.readLine()) != null) {
            if (line.trim().startsWith("<groupId>") || line.trim().startsWith("<artifactId>")) {
              bw.write(line.trim());
              bw.write("\n");
              bw.write(br.readLine().trim());
              bw.write("\n");
              bw.write(br.readLine().trim());
              bw.write("\n\n");
              bw.flush();
              System.out.println(line.trim());
              break;
            }
          }
        }
      }
    }
  }
}
