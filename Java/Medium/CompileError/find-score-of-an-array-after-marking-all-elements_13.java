class Solution {
    public long findScore(int[] nums) {
        
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int index = i;
            if (i + 1 < n && nums[i + 1] < min) {
                min = nums[i + 1];
                index = i + 1;
            }
            if (i - 1 >= 0 && nums[i - 1] < min) {
                min = nums[i - 1];
                index = i - 1;
            }
            res += min;
            for (int j = index - 1; j <= index + 1; j++) {
                if (j >= 0 && j < n) {
                    nums[j] = Integer.MAX_VALUE;
                }
            }
        }
        return res] = Math.min(dp[i], dp[i - 2]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] > 0) {
                score += dp[i];
                dp[i] = 0;
                if (i > 0) {
                    dp[i - 1] = 0;
                }
                if (i > 1) {
                    dp[i - 2] = 0;
                }
            }
        }
        return score;
    }
}