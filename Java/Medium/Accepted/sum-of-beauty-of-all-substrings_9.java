class Solution {
    public int beautySum(String s) {
        
        int i, j, k, l, n = s.length();
        int[] cnt = new int[26];
        int[][] pre = new int[n][26];
        int ans = 0;
        for (i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - 'a'];
            for (j = 0; j < 26; ++j) {
                pre[i][j] = cnt[j];
            }
        }
        for (i = 0; i < n; ++i) {
            for (j = i; j < n; ++j) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (k = 0; k < 26; ++k) {
                    int c = pre[j][k] - (i > 0 ? pre[i - 1][k] : 0);
                    if (c > 0) {
                        min = Math.min(min, c);
                        max = Math.max(max, c);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}