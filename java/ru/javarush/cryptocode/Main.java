package ru.javarush.cryptocode;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        String message = "";
        String encryptedMessage = "";
        String decryptedMessage = "";
        char key = 13;

        // Читаем данные из файла
        File file = new File("sample3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Шифруем текст из файла
        while ((message = br.readLine()) != null) {
            String newMessage = message.toLowerCase();
            for (int x = 0; x < newMessage.length(); x++) {
                encryptedMessage += (char) (message.charAt(x) + key);
            }
        }

        // Выводим зашифрованный текст на экран
        System.out.println(encryptedMessage);

        // Расшифровываем текст
        for (int x = 0; x < encryptedMessage.length(); x++) {
            decryptedMessage += (char) (encryptedMessage.charAt(x) - key);
        }

        // Записываем в файл
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(decryptedMessage);
        } catch(IOException ex){
            System.out.println("Не удалось записать данные в файл");
        }

    }
}
