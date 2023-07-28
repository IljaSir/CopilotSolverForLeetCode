class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int i = 1; i < (1 << n); i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cnt++;
                }
            }
            dp[i] = cnt;
        }
        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    for (int l = j + 1; l < n; l++) {
                        if (((i >> l) & 1) == 1) {
                            if (Math.abs(nums[j] - nums[l]) == k) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (flag) {
                ans += dp[i];
            }
        }
        return ans;
    }
}