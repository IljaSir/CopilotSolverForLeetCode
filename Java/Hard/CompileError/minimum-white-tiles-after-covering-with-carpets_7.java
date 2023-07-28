class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] sum = new int[n];
        int[] ones = new int[n];
        for (int i = 0; i < n; i++) {
            ones[i] = floor.charAt(i) - '0';
            if (i > 0) {
                ones[i] += ones[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (floor.charAt(i) == '1') {
                dp[i] = 1;
            }
            if (i > 0) {
                dp[i] += dp[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - carpetLen + 1);
            int end = i;
            pre[i] = dp[end] - (start > 0 ? dp[start - 1] : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            int start = i;
            int end = Math.min(n - 1, i + carpetLen - 1);
            suf[i] = dp[end] - (start > 0 ? dp[start - 1] : 0);
        }
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = Math.min(n - 1, i + carpetLen - 1);
            sum[i] = ones[end] - (start > 0 ? ones[start - 1] : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - carpetLen + 1; i++) {
            int left = Math.max(0, i - carpetLen);
            int right = Math.min(n - carpetLen, i + carpetLen - 1);
            int cur = sum[i] + ones[n - 1] - ones[i + carpetLen - 1] - (left > 0 ? ones[left - 1] : 0);
            if (left > 0) {
                cur += pre[left - 1];
            }
            if (
    }
}