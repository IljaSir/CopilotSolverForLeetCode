class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[700*70+1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for (int[] row : mat) {
            int[] dp2 = new int[700*70+1];
            Arrays.fill(dp2, 100000);
            for (int i = 0; i <= 700*70; i++) {
                for (int x : row) {
                    if (i + x <= 700*70) {
                        dp2[i+x] = Math.min(dp2[i+x], dp[i]);
                    }
                }
            }
            for (int i = 0; i <= 700*70; i++) {
                dp2[i] = Math.min(dp2[i], dp2[i-1] + 1);
            }
            dp = dp2;
        }
        int ans = 100000;
        for (int i = 0; i <= 700*70; i++) {
            if (i >= target) {
                ans = Math.min(ans, dp[i] + i - target);
            } else {
                ans = Math.min(ans, dp[i] + target - i);
            }
        }
        return ans;
    }
}