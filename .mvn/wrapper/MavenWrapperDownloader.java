import java.io.*;
import java.net.*;

public class MavenWrapperDownloader {

    private static final String WRAPPER_VERSION = "0.5.6";
    private static final String MAVEN_WRAPPER_URL = "https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/"
            + WRAPPER_VERSION + "/maven-wrapper-" + WRAPPER_VERSION + ".jar";

    private static final String ERROR_MESSAGE = "Error downloading Maven Wrapper. Please check your internet connection.";

    public static void main(String[] args) {
        File baseDirectory = new File(args[0]);
        System.out.println("Downloading Maven Wrapper...");
        downloadMavenWrapper(baseDirectory);
        System.out.println("Maven Wrapper downloaded successfully.");
    }

    private static void downloadMavenWrapper(File baseDirectory) {
        File wrapperDirectory = new File(baseDirectory, ".mvn/wrapper");
        if (!wrapperDirectory.exists()) {
            wrapperDirectory.mkdirs();
        }

        File outputFile = new File(wrapperDirectory, "maven-wrapper.jar");
        if (outputFile.exists()) {
            return;
        }

        try {
            URL url = new URL(MAVEN_WRAPPER_URL);
            try (InputStream in = url.openStream();
                    FileOutputStream fos = new FileOutputStream(outputFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            System.out.println(ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}