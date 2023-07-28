class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        // Check if the two strings are equal
        if (word1.equals(word2)) return true;
        // Create a hashset for each string
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
        // Add each character to the hashset
        for (int i = 0; i < word1.length(); i++) {
            set1.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            set2.add(word2.charAt(i));
        }
        // Check if the two sets are equal
        if (set1.equals(set2)) return true;
        // Check if the two sets have at least 2 characters
        if (set1.size() < 2 && set2.size() < 2) return false;
        // Create a hashmap to count the number of characters
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0) + 1);
        }
        // Check if the hashmap has any characters with a count of 1
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return false;
        }
        return true;
    }
}