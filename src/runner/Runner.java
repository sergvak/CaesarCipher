package runner;

import cipher.CaesarCipher;
import io.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Runner {
    private FileService fileService;
    private CaesarCipher caesar;

    public Runner(FileService fileService, CaesarCipher caesar) {
        this.fileService = fileService;
        this.caesar = caesar;
    }

    public void runs(String[] args) throws IOException {
        if (args.length > 0) {
            if (args[0].equals("ENCRYPT")) {

                String command = args[0];
                String filePath = args[1];
                if (fileService.isFileExit(Path.of(filePath))) {

                    int key = Integer.parseInt(args[2]);

                    if (key > 0) {
                        encrypt(filePath, key);
                    } else {
                        errorKey();
                    }

                } else {
                    errorFile();
                }

            } else if (args[0].equals("DECRYPT")) {

                String command = args[0];
                String filePath = args[1];

                if (fileService.isFileExit(Path.of(filePath))) {

                    int key = Integer.parseInt(args[2]);

                    if (key > 0) {
                        decrypt(filePath, key);
                    } else {
                        errorKey();
                    }

                } else {
                    errorFile();
                }

            } else if (args[0].equals("BRUTE_FORCE")) {

                String filePath = args[1];

                if (fileService.isFileExit(Path.of(filePath))) {
                    brute(filePath);
                } else {
                    errorFile();
                }

            } else {
                errorCommand();
            }

        } else {

            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do with text?");
            System.out.println("Write one of the commands and press enter.");

            System.out.print("ENCRYPT | DECRYPT | BRUTE_FORCE: ");
            String command = scanner.nextLine();

            if (command.equals("ENCRYPT")) {

                System.out.print("Write path to the file: ");
                String filePath = scanner.nextLine();

                if (fileService.isFileExit(Path.of(filePath))) {

                    System.out.print("Write the key (positive integer number): ");
                    int key = scanner.nextInt();

                    if (key > 0) {
                        encrypt(filePath, key);
                    } else {
                        errorKey();
                    }

                } else {
                    errorFile();
                }

            } else if (command.equals("DECRYPT")) {

                System.out.print("Write path to the file: ");
                String filePath = scanner.nextLine();

                if (fileService.isFileExit(Path.of(filePath))) {

                    System.out.print("Write the key (positive integer number): ");
                    int key = scanner.nextInt();

                    if (key > 0) {
                        decrypt(filePath, key);
                    } else {
                        errorKey();
                    }

                } else {
                    errorFile();
                }

            } else if (command.equals("BRUTE_FORCE")) {

                System.out.print("Write path to the file: ");
                String filePath = scanner.nextLine();

                if (fileService.isFileExit(Path.of(filePath))) {
                    brute(filePath);
                } else {
                    errorFile();
                }

            } else {
                errorCommand();
            }

        }
    }

    public void encrypt(String filePath, int key) throws IOException {
        Path of = Path.of(filePath);
        String textStart = fileService.read(of);
        String textEnd = caesar.decryptEncrypt("ENCRYPT", key, textStart);
        fileService.write(fileService.addFileNameAnnotation(of, "[ ENCRYPTED ]"), textEnd);
    }

    public void decrypt(String filePath, int key) throws IOException {
        Path of = Path.of(filePath);
        String textStart = fileService.read(of);
        String textEnd = caesar.decryptEncrypt("DECRYPT", key, textStart);
        fileService.write(fileService.addFileNameAnnotation(of, "[ DECRYPTED ]"), textEnd);
    }

    public void brute(String filePath) throws IOException {
        Path of = Path.of(filePath);
        String textStart = fileService.read(of);
        caesar.bruteForce(textStart);
        String textEnd = caesar.getTextEnd();
        String keyE = String.valueOf(caesar.getKeyEnd());
        fileService.write(fileService.addFileNameAnnotation(of, "[ BRUTE_FORCE, key = " + keyE + " ]"), textEnd);
    }

    public void errorCommand() {
        System.out.println("*-----*-----*-----*-----*-----*-----*-----*\nError! You write incorrect command.");
        System.out.println("Restart program and use one of the commands: ENCRYPT / DECRYPT / BRUTE_FORCE.");
    }

    public void errorFile() {
        System.out.println("*-----*-----*-----*-----*-----*-----*-----*\nError! File not found.");
        System.out.println("Restart program and use correct file path.");
    }

    public void errorKey() {
        System.out.println("*-----*-----*-----*-----*-----*-----*-----*\nError! You write incorrect key.");
        System.out.println("Restart program and use positive integer number.");
    }
}