class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n];
        int[] sum = new int[n];
        int[] prefixSum = new int[n];
        int[] prefixMax = new int[n];
        int[] prefixMax2 = new int[n];
        int[] prefixSum2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = floor.charAt(i) == '1' ? 1 : 0;
                sum[i] = dp[i];
            } else {
                dp[i] = dp[i - 1] + (floor.charAt(i) == '1' ? 1 : 0);
                sum[i] = dp[i] + sum[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefixSum[i] = sum[i];
                prefixMax[i] = dp[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + sum[i];
                prefixMax[i] = Math.max(prefixMax[i - 1], dp[i]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                prefixSum2[i] = sum[i];
                prefixMax2[i] = dp[i];
            } else {
                prefixSum2[i] = prefixSum2[i + 1] + sum[i];
                prefixMax2[i] = Math.max(prefixMax2[i + 1], dp[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i + carpetLen - 1;
            int l2 = i + carpetLen;
            int r2 = i + carpetLen * 2 - 1;
            int l3 = i + carpetLen * 2;
            int r3 = i + carpetLen * 3 - 1;
            int l4 = i + carpetLen * 3;
            int r4 = i + carpetLen * 4 - 1;
            if (r < n) {
                int val = 0;
                if (l
    }
}