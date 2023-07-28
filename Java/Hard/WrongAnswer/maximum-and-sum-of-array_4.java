class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[] dp = new int[1 << numSlots];
        int[] cnt = new int[1 << numSlots];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i < (1 << numSlots); i++) {
            int j = i & (-i);
            dp[i] = dp[i - j] + cnt[j];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = nums[i];
            int k = (1 << numSlots) - 1 - j;
            for (int l = k; l > 0; l = (l - 1) & k) {
                if (dp[l] >= 2) {
                    res = Math.max(res, l & j);
                }
            }
            res = Math.max(res, j & k);
        }
        return res;
    }
}