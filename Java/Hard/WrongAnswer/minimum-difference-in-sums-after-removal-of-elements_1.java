class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long min = sum;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, sum - (long) 2 * nums[i] - (long) 2 * nums[i + n]);
        }
        return min;
    }
}