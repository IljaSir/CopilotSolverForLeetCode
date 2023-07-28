class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0], max = nums[n - 1];
        int res = max - min;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(nums[i] + 2 * k, max);
            min = Math.min(nums[i + 1], nums[0] + 2 * k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}