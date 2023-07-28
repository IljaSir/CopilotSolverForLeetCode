class Solution {
    public int similarPairs(String[] words) {
        
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isSimilar(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}