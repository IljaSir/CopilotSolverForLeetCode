class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] d = new int[26];
        for (int i = 0; i < order.length(); i++) {
            d[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], d)) {
                return false;
            }
        }
        return true;
    }
    private boolean compare(String str1, String str2, int[] d) {
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0;
        while (i < len1 && i < len2) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return d[str1.charAt(i) - 'a'] < d[str2.charAt(i) - 'a'];
            }
            i++;
        }
        return len1 <= len2;
    }
}