class Solution {
    public boolean isPossible(int[] nums) {
        
        int n = nums.length;
        if (n < 3) return false;
        int cnt = 1, i = 1;
        while (i < n && nums[i] == nums[i - 1]) {
            cnt++;
            i++;
        }
        if (cnt < 3) return false;
        int[] dp = new int[n];
        dp[0] = cnt;
        for (int j = 1; j < n; j++) {
            dp[j] = 1;
            int k = j - 1;
            while (k >= 0 && nums[k] == nums[j]) {
                k--;
            }
            if (k >= 0) {
                if (nums[k] == nums[j] - 1) {
                    if (dp[k] == 1) return false;
                    dp[j] = dp[k] - 1;
                } else {
                    if (dp[k] < 3) return false;
                }
            }
        }
        return true;
    }
}