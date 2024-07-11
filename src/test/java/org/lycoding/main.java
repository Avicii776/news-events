package org.lycoding;


import org.junit.jupiter.api.Test;

import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fos = new FileOutputStream("D:\\Desktop\\test.txt",true);
//        String str = "\r\n"+"abcd";
//        fos.write(str.getBytes());
//        fos.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\Desktop\\test.txt");
        int read = fileInputStream.read();
        byte[] bytes = fileInputStream.readAllBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char) bytes[i]);
        }
    }

    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\5G\\5G\\img\\index.mp4");

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Desktop\\copy.mp4",true);

        byte[] bytes = fileInputStream.readAllBytes();

        for (int i = 0; i < bytes.length; i++) {
            fileOutputStream.write(bytes[i]);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }
}
