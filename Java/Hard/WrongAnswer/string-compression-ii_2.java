class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                count[idx]++;
                int maxCount = 0;
                int maxCountChar = 0;
                for (int l = 0; l < 26; l++) {
                    if (count[l] > maxCount) {
                        maxCount = count[l];
                        maxCountChar = l;
                    }
                }
                int diff = j - i + 1 - maxCount;
                for (int l = 0; l <= k; l++) {
                    if (l + diff <= k) {
                        dp[j + 1][l + diff] = Math.min(dp[j + 1][l + diff], dp[i][l] + getLength(maxCount) + (maxCountChar == idx ? 0 : 1));
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }

    private int getLength(int n) {
        if (n == 1) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        if (n < 100) {
            return 2;
        }
        return 3;
    }
}