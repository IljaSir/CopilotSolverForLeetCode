class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], orderMap) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private int compare(String word1, String word2, int[] orderMap) {
        int n = Math.min(word1.length(), word2.length());
        for (int i = 0; i < n; i++) {
            int c1 = orderMap[word1.charAt(i) - 'a'];
            int c2 = orderMap[word2.charAt(i) - 'a'];
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return word1.length() - word2.length();
    }
}