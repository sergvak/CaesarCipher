package cli;

import java.util.Scanner;

public class Cli {
    private String command;
    private String filePath;
    private int key;

    public String getCommand() {
        return command;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getKey() {
        return key;
    }

    public Cli(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do with text?");
        System.out.println("Write one of the commands and press enter.");
        System.out.print("ENCRYPT | DECRYPT | BRUTE_FORCE: ");
        this.command = scanner.nextLine();
        System.out.print("Write path to the file: ");
        this.filePath = scanner.nextLine();
        System.out.print("Write the key: ");
        this.key = scanner.nextInt();
    }
}