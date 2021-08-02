package treinamento.chrono.treinamento.util;


import org.springframework.http.HttpStatus;
import treinamento.chrono.treinamento.exception.GlobalException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

public class CsvUtil {

    public static Path writeCsvFile(String headers, List<String> strings) throws IOException {

        strings.add(0, headers);
        strings.replaceAll(s -> s.replace(",",";"));

        Path path = Paths.get("C:\\Users\\zeck\\Desktop\\teste.csv");

        if(Files.notExists(path)){
            Files.createFile(path);
        }
        Files.write(path, strings, ISO_8859_1);
        return path;

    }

    public static void readCsvFile() throws IOException {
        Path path = Paths.get("C:\\Users\\zeck\\Desktop\\teste.csv");

        List<String> list;

        if(Files.exists(path)){
            list = Files.readAllLines(path, ISO_8859_1);
        }else{
            throw  new GlobalException("", "", HttpStatus.INTERNAL_SERVER_ERROR);
        }
            list.remove(0);
    }

}
