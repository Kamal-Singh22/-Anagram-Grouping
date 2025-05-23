import java.util.*;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] words = {"bat", "tab", "tap", "pat", "cat"};
        List<List<String>> groupedAnagrams = groupAnagrams(words);

        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // Sort characters of the word
            String sortedWord = new String(chars);

            // Group by the sorted word
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
