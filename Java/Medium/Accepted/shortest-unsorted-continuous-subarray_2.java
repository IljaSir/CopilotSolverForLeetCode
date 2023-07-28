class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int start = -1, end = -2;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if (nums[i] < max) end = i;
            if (nums[n - i - 1] > min) start = n - i - 1;
        }
        return end - start + 1;
    }
}