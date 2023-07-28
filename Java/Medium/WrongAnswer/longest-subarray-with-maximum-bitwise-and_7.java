class Solution {
    public int longestSubarray(int[] nums) {
        
        int max = 0;
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = nums[0];
        maxRight[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = maxLeft[i-1] & nums[i];
        }
        for (int i = n-2; i >= 0; i--) {
            maxRight[i] = maxRight[i+1] & nums[i];
        }
        for (int i = 0; i < n-1; i++) {
            max = Math.max(max, maxLeft[i] & maxRight[i+1]);
        }
        return max;
    }
}