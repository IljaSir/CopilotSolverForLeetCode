class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] orderMap) {
        int len1 = word1.length();
        int len2 = word2.length();
        for (int i = 0; i < len1 && i < len2; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return orderMap[word1.charAt(i) - 'a'] < orderMap[word2.charAt(i) - 'a'];
            }
        }
        return len1 <= len2;
    }
}