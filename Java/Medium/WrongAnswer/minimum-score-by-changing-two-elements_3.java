class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[n-1] = nums[n-1];
        max[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], nums[i]);
            max[i] = Math.max(max[i+1], nums[i]);
        }
        int low = 0, high = 0;
        for (int i = 0; i < n-1; i++) {
            low = Math.max(low, Math.abs(nums[i] - min[i+1]));
            high = Math.max(high, Math.abs(nums[i] - max[i+1]));
        }
        return low + high;
    }
}