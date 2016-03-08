package com.birthday.bot.tools.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Vsevolod Kaimashnikov on 28.02.2016.
 */
public class FileUtils {

    public static void write(final String fileName, final String text) {

        final File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            final PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

    public static void delete(final String fileName) {

        final File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        }
    }
}
