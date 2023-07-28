class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderDict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderDict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderDict)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] orderDict) {
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            if (orderDict[word1.charAt(i) - 'a'] < orderDict[word2.charAt(i) - 'a']) {
                return true;
            }
            if (orderDict[word1.charAt(i) - 'a'] > orderDict[word2.charAt(i) - 'a']) {
                return false;
            }
        }
        return word1.length() <= word2.length();
    }
}