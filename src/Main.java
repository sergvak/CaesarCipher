import cipher.CaesarCipher;
import io.FileService;
import runner.Runner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        CaesarCipher caesar = new CaesarCipher();
        Runner runner = new Runner(fileService, caesar);
        runner.runs(args);
    }
}