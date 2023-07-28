class Solution {
    public int longestSubstring(String s, int k) {
        
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char c: chars) {
            count[c - 'a']++;
        }
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < chars.length) {
            if (count[chars[j] - 'a'] < k) {
                if (i != j) {
                    max = Math.max(max, longestSubstring(s.substring(i, j), k));
                }
                i = j + 1;
            }
            j++;
        }
        return i == 0 ? s.length() : Math.max(max, longestSubstring(s.substring(i), k));
    }
}