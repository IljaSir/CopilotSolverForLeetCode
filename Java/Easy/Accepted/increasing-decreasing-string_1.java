class Solution {
    public String sortString(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }
}