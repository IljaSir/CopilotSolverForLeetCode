class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int preSum = 0;
        long ans = 0;
        for (int num : nums) {
            preSum += num;
            if (preSum >= k) {
                ans += count[preSum - k];
            }
            count[preSum]++;
        }
        return ans;
    }
}