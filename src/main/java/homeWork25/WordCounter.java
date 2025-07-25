package homeWork25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "text.txt";
        List<String> words = readWordsFromFile(filePath);

        Collections.sort(words);
        System.out.println("Слова в алфавитном порядке:");
        for(String word : words){
            System.out.print(word+"\t");
        }

        Map<String, Integer> wordFrequency = wordFrequency(words);
        System.out.println("\nЧастота слов в тексте: ");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()){
            System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
            System.out.print(Math.round((double) entry.getValue() / words.size() * 100 * 100) / 100.0 + "% \n");
        }

        System.out.println("\nСамые часто встречающиеся слова:");
        findMaxFrequencyWords(wordFrequency);
    }

    private static void findMaxFrequencyWords(Map<String, Integer> wordFrequency) {
        int maxFrequency = Collections.max(wordFrequency.values());
        for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()){
            if (entry.getValue() == maxFrequency) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static List<String> readWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("[\\p{L}']+");

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                Matcher matcher = wordPattern.matcher(line.toLowerCase());
                while (matcher.find()){
                    words.add(matcher.group());
                }
            }
        } catch (IOException e){
            e.getMessage();
        }
        return words;
    }

    private static Map<String, Integer> wordFrequency(List<String> words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }
}