class Solution {
    public int longestSubstring(String s, int k) {
        
        int res = 0;
        for (int t = 1; t <= 26; t++) {
            int[] cnt = new int[26];
            int total = 0;
            int less = 0;
            int i = 0;
            int j = 0;
            while (j < s.length()) {
                cnt[s.carA(j - 'a']++;
                if (cnt[s.charAt(j) - 'a'] == 1) {
                    total++;
                    less++;
                }
                if (cnt[s.charAt(j) - 'a'] == k) {
                    less--;
                }
                while (total > t) {
                    cnt[s.charAt(i) - 'a']--;
                    if (cnt[s.charAt(i) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(i) - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    i++;
                }
                if (less == 0) {
                    res = Math.max(res, j - i + 1);
                }
                j++;
            }
        }
        return res
            ans = Math.max(ans, longestSubstring(s.substring(start), k));
        }
        return ans;
    }
}