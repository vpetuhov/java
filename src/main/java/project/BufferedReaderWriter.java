package project;

import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("outputFile.txt"))) {
            int ch;
            while ((ch = br.read()) != -1) {
                char c = (char) ch;
                if (isVowel(c)) {
                    bw.write('а');
                } else if (isConsonant(c)) {
                    bw.write('м');
                } else {
                    bw.write(c);
                }
            }
            bw.close();

            int[] counts = countVowelandConsonant("outputFile.txt");
            System.out.println("Количество гласных букв: " + counts[0]);
            System.out.println("Количество согласных букв: " + counts[1]);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isVowel(char c) {
        return "аеёиоуыэюя".indexOf(Character.toLowerCase(c)) != -1;
    }

    private static boolean isConsonant(char c) {
        return "бвгджзйклмнпрстфхцчшщ".indexOf(Character.toLowerCase(c)) != -1;
    }

    private static int[] countVowelandConsonant(String outputFile) {
        int vowels = 0;
        int consonants = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            int ch;
            while ((ch = br.read()) != -1) {
                char c = (char) ch;
                if(isVowel(c)){
                    vowels++;
                } else if (isConsonant(c)) {
                    consonants++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new int[]{vowels, consonants};
    }
}