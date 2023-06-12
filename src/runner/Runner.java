package runner;

import cipher.CaesarCipher;
import cli.Cli;
import io.FileService;

import java.io.IOException;

public class Runner {
    private FileService fileService;
    private CaesarCipher cipher;

    public Runner(FileService fileService, CaesarCipher cipher) {
        this.fileService = fileService;
        this.cipher = cipher;
    }

    public void runs(String[] args) throws IOException {
        if (args.length > 0) {

        } else {
            new Cli();
        }
    }
}
