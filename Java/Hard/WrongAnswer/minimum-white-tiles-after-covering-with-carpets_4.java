class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int[] sum = new int[n + 1];
        int[] sum2 = new int[n + 1];
        int[] sum3 = new int[n + 1];
        int[] sum4 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (floor.charAt(i) == '1' ? 1 : 0);
            sum2[i + 1] = sum2[i] + (floor.charAt(i) == '1' ? 0 : 1);
            sum3[i + 1] = sum3[i] + (floor.charAt(i) == '1' ? 1 : 0);
            sum4[i + 1] = sum4[i] + (floor.charAt(i) == '1' ? 0 : 1);
        }
        for (int i = 0; i <= n; i++) {
            dp[i] = sum[n] - sum[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = sum2[n] - sum2[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = sum3[i] + sum4[n] - sum4[i];
            int l = i + carpetLen;
            int r = n - carpetLen;
            if (l > r) continue;
            int left = sum3[l] + sum4[n] - sum4[l];
            int right = sum3[r] + sum4[n] - sum4[r];
            if (left < right) {
                int cur = t + left;
                if (numCarpets > 1) {
                    cur += dp[l + carpetLen];
                }
                ans = Math.min(ans, cur);
            } else {
                int cur = t + right;
                if (numCarpets > 1) {
                    cur += dp2[r - carpetLen];
                }
                ans = Math.min(ans, cur);
            }
        }
        return ans;
    }
}