class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[] dp = new int[1 << numSlots];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[1 << numSlots];
            for (int j = 0; j < (1 << numSlots); j++) {
                temp[j] = dp[j];
                if (j < (1 << (numSlots - 1))) {
                    temp[j] = Math.max(temp[j], dp[j | (1 << (numSlots - 1))] + (nums[i] & j));
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}