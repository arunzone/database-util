package me.arun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader
{
   public String read(String fileName) throws IOException {
       return new String(Files.readAllBytes(Paths.get(fileName)));
   }
}
