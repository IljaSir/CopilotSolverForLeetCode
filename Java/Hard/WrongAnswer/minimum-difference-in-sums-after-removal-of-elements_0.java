class Solution {
    public long minimumDifference(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length / 3;
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
            sum2 += nums[2 * n + i];
        }
        long min = sum2 - sum1;
        for (int i = n; i < 2 * n; i++) {
            sum1 += nums[i];
            sum2 -= nums[i];
            min = Math.min(min, sum2 - sum1);
        }
        return min;
    }
}