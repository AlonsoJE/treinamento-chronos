package treinamento.chrono.treinamento.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_16;

public class CsvUtil {

    public static Path writeCsvFile(String headers, List<String> strings) throws IOException {

        strings.add(0, headers);
        strings.replaceAll(s -> s.replace(",",";"));

        Path path = Paths.get("C:\\Users\\zeck\\Desktop\\teste.csv");

        if(Files.notExists(path)){
            Files.createFile(path);
        }
        Files.write(path, strings, UTF_16);
        return path;
    }

    public static void readCsvFile(){

    }

}
