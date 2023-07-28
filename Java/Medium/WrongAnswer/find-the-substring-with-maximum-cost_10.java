class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] score = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            score[chars.charAt(i) - 'a'] = vals[i];
        }
        int[] sum = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            sum[i] = sum[i - 1] + score[s.charAt(i - 1) - 'a'];
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = s.length();
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (sum[m] - sum[i] > 0) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            res = Math.max(res, l - i + 1);
        }
        return res;
    }
}