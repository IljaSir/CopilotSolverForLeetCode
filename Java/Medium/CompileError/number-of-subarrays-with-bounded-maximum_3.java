class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int result = 
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i;
                end = i;
            } else if (nums[i] < left) {
                ans += end - start;
            } else {
                end = i;
                ans += end - start;
            }
        }
        return result;
    }
}