class Solution {
    public int minDifference(int[] nums) {
        
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, nums[n - 1 - 3 + i] - nums[i]);
        }
        return min;
    }
}