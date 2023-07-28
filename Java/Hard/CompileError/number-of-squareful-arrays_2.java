class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 0; i < (1 << n); i++) {
            int last = -1;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    if (last != -1 && nums[last] == nums[j]) {
                        continue;
                    }
                    if (last == -1 || isSquare(nums[last] + nums[j])) {
                        dp[i] += dp[i ^ (1 << j)];
                    }
                    last = j;
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}