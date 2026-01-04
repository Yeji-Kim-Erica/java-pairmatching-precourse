package pairmatching.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 파일 내용을 변환하는 유틸리티 클래스
 */

public final class FileParser {

    private FileParser() {}

    public static List<String> getInfo(File file) {
        return readFile(file.getPath());
    }

    private static List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
