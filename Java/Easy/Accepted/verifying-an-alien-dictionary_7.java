class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], charOrder)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSorted(String s1, String s2, int[] charOrder) {
        for (int i = 0; i < s1.length(); i++) {
            if (i == s2.length()) {
                return false;
            }
            if (charOrder[s1.charAt(i) - 'a'] < charOrder[s2.charAt(i) - 'a']) {
                return true;
            }
            if (charOrder[s1.charAt(i) - 'a'] > charOrder[s2.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}