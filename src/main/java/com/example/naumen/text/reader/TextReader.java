package com.example.naumen.text.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    public List<String> read(Path path) throws IOException {
        BufferedReader reader;
        List<String> res = new ArrayList<>();
        reader = new BufferedReader(new FileReader(path.toString()));
        String line = reader.readLine();
        while (line != null) {
//            System.out.println(line);
            if (checkFormat(line)) {
                res.add(line);
            } else {
                System.err.println("The line '" + line + "' is incorrectly formatted");
            }
            line = reader.readLine();
        }

        reader.close();
        return res;
    }

    private boolean checkFormat(String str) {
        return str.matches("[A-zА-я][A-zА-я]*_\\d+");
    }
}
