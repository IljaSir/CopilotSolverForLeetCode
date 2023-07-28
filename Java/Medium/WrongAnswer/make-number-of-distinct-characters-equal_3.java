class Solution {
    public boolean isItPossible(String word1, String word2) {
        
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }
        return diff <= 2;
    }
}