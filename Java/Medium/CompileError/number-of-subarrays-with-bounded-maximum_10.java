class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int ans =  = 0;
        int last = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                result += i - last;
                count = i - last;
            } else if (nums[i] < left) {
                result += count;
            } else {
                last = i;
                count = 0;
            }
        }
        return result;
    }
}