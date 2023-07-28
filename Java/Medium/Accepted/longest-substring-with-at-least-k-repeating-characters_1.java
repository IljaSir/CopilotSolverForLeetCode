class Solution {
    public int longestSubstring(String s, int k) {
        
        int n = s.length();
        if (n < k) {
            return 0;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        boolean allOk = true;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                allOk = false;
                break;
            }
        }
        if (allOk) {
            return n;
        }
        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        res = Math.max(res, longestSubstring(s.substring(start), k));
        return res;
    }
}