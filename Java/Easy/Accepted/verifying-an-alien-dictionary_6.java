class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderIndex = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderIndex[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderIndex)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSorted(String word1, String word2, int[] orderIndex) {
        for (int i = 0; i < word1.length(); i++) {
            if (i >= word2.length()) {
                return false;
            }
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 != c2) {
                return orderIndex[c1 - 'a'] < orderIndex[c2 - 'a'];
            }
        }
        return true;
    }
}