class Solution {
    public int longestSubstring(String s, int k) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int split = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                split = i;
                break;
            }
        }
        if (split == 0) {
            return s.length();
        }
        String[] subs = s.split(String.valueOf((char) ('a' + split)));
        int res = 0;
        for (String sub : subs) {
            res = Math.max(res, longestSubstring(sub, k));
        }
        return res;
    }
}