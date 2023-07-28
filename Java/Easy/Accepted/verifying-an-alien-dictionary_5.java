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
    private boolean isSorted(String a, String b, int[] orderMap) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 != c2) {
                return orderMap[c1 - 'a'] < orderMap[c2 - 'a'];
            }
        }
        return a.length() <= b.length();
    }
}