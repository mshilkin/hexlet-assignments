package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.io.File;
import java.util.stream.Stream;

import static java.lang.Integer.sum;

class App {

    // BEGIN
    public static  CompletableFuture<String> unionFiles(String file1Path, String file2Path, String destPath) {
        return  CompletableFuture.supplyAsync(() -> {
            try {
                Path file1 = Paths.get(file1Path);
                Path file2 = Paths.get(file2Path);
                Path dest = Paths.get(destPath);

                if (!Files.exists(file1) || !Files.exists(file2)) {
                    throw new NoSuchFileException("One or both source files do not exist!");
                }

                String content1 = new String(Files.readAllBytes(file1));
                String content2 = new String(Files.readAllBytes(file2));
                String combinedContent = content1 + content2;

                Files.write(dest, combinedContent.getBytes());
                return  "Files successfully combined and written to " + destPath;
            } catch (NoSuchFileException e) {
                System.out.println("NoSuchFileException");
                return "NoSuchFileException";
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
                return "NoSuchFileException";
            }
        });
    }

    public  static CompletableFuture<Long> getDirectorySize(String dirPath) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path dir = Paths.get(dirPath);
                if (!Files.isDirectory(dir)) {
                    throw new IOException("The provided path is not a directory.");
                }

                try (Stream<Path> files = Files.list(dir)) {
                    return files.filter(Files::isRegularFile)
                            .mapToLong(path -> {
                                try {
                                    return  Files.size(path);
                                } catch (IOException e) {
                                    System.out.println("Exception occurred while getting size of files" + e.getMessage());
                                    return  0L;
                                }
                            })
                            .sum();
                }
            } catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());
                return 0L;
                }
        });
    }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "java-advanced-ru/asynchrony/src/main/resources/file1.txt",  //"src/main/resources/file1.txt",
                "java-advanced-ru/asynchrony/src/main/resources/file2.txt",//"src/main/resources/file2.txt",
                "java-advanced-ru/asynchrony/src/main/resources/combined.txt" //"resources/combined.txt"
                 );


        result.thenAccept(System.out::println);

        CompletableFuture<Long> sizeFuture = getDirectorySize("java-advanced-ru/asynchrony/src/main/resources");
        sizeFuture.thenAccept(size -> System.out.println("Total size of files in directory: " + size + " bytes"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }
        // END
    }
}

