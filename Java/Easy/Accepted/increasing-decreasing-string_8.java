class Solution {
    public String sortString(String s) {
        
        int[] c = new int[26];
        for (char ch: s.toCharArray())
            c[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (c[i]-- > 0) sb.append((char) ('a' + i));
            }
            for (int i = 25; i >= 0; i--) {
                if (c[i]-- > 0) sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}