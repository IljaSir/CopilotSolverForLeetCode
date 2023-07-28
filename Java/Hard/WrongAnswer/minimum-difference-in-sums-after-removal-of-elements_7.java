class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        Arrays.sort(nums);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = 2 * n + i;
            min = Math.min(min, (long) nums[j] - nums[i + n]);
        }
        return min;
    }
}