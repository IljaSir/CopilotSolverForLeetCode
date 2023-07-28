class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0 && freq2[i] == 0) {
                diff++;
            }
        }
        return diff <= 1;
    }
    public boolean buddyStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return isItPossible(word1, word2);
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if (first == -1 || second == -1) {
            return false;
        }
        return word1.charAt(first) == word2.charAt(second) && word1.charAt(second) == word2.charAt(first);
    }
}