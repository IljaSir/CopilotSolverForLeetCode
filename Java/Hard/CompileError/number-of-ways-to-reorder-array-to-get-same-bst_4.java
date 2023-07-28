class Solution {
    public int numOfWays(int[] nums) {
        
        int mod = 1_000_000_007;
        int n = nums.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = dp[i][i][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int left = j, right = i;
                while (left < right) {
                    int mid = left + right + 1 >> 1;
                    if (nums[mid] < nums[j]) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                int l = 0, r = 0;
                if (left == j) {
                    l = 1;
                } else {
                    l = (int)(((long)dp[j + 1][left][0] * dp[left + 1][i][0] + (long)dp[j + 1][left][1] * dp[left + 1][i][1]) % mod);
                }
                left = j;
                right = i;
                while (left < right) {
                    int mid = left + right >> 1;
                    if (nums[mid] > nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left == i) {
                    r = 1;
                } else {
                    r = (int)(((long)dp[j][left - 1][0] * dp[left][i - 1][0] + (long)dp[j][left - 1][1] * dp[left][i - 1][1]) % mod);
                }
                dp[j][i][0] = (int)((long)l * r % mod);
                dp[j][i][1] = (int)(((long)dp[j + 1][i][0] + dp[j][i - 1][0] - l + mod) % mod);
            }
        }
        return (dp[0][n - 1][0] + dp[0][n - 1][1] - 1 + mod) % mod
    }
}