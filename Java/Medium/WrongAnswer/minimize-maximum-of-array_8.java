class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int min = sum;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            min = Math.min(min, Math.max(sum, max));
            max = Math.max(max, nums[i]);
        }
        return min;
    }
}