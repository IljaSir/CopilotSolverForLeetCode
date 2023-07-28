class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], orderMap) > 0) {
                return false;
            }
        }
        return true;
    }
    private int compare(String word1, String word2, int[] orderMap) {
        int length = Math.min(word1.length(), word2.length());
        for (int i = 0; i < length; i++) {
            int order1 = orderMap[word1.charAt(i) - 'a'];
            int order2 = orderMap[word2.charAt(i) - 'a'];
            if (order1 != order2) {
                return order1 - order2;
            }
        }
        return word1.length() - word2.length();
    }
}