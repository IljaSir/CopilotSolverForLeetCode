class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int max = 0;
        int n = nums.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0) {
                    curr |= nums[j];
                }
            }
            dp[i] = curr;
            max = Math.max(max, curr);
        }
        int count = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i] == max) {
                count++;
            }
        }
        return count;
    }
}