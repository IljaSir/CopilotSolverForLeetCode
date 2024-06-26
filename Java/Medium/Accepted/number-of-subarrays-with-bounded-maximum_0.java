class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int res = 0, l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                l = i;
            }
            if (nums[i] >= left) {
                r = i;
            }
            res += r - l;
        }
        return res;
    }
}