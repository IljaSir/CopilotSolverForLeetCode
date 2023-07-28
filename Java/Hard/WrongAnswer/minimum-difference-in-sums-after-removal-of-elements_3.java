class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        Arrays.sort(nums);
        long sumfirst = 0;
        long sumsecond = 0;
        for (int i = 0; i < n; i++) {
            sumfirst += nums[i];
        }
        for (int i = n; i < 2 * n; i++) {
            sumsecond += nums[i];
        }
        long min = sumfirst - sumsecond;
        for (int i = 0; i < n; i++) {
            sumfirst -= nums[i];
            sumfirst += nums[i + n];
            sumsecond -= nums[i + n];
            sumsecond += nums[i + 2 * n];
            min = Math.min(min, Math.abs(sumfirst - sumsecond));
        }
        return min;
    }
}