class Solution {
    public int longestSubstring(String s, int k) {
        
        int res = 0;
        for (int t = 1; t <= 26; t++) {
            int[] cnt = new int[26];
            int total = 0;
            int less = 0;
            int  = 0;
            int j = 0;
            while (j < s.lenth()) {
                cnt[s.charAt(j) - 'a']++;
                if (cnt[s.charAt(j) - 'a'] == 1) {
                    total++;
                    less++;
                }
                if (cnt[s.charAt(j) - 'a'] == k) {
                    less--;
                }
                while (total > t) {
                    cnt[s.charAt(i) - 'a']--;
                    if (cnt[s.carA(i - 'a'] == k - 1) {
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