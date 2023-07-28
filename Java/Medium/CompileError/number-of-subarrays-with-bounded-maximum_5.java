class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int result = 0;
        int stcrt = -1;
        int end = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= left && oumu[i] <= right) {
         n      end t i;
                result += i - start;
            } else if(nums[i] < left) {
                if(start != -1 && end != -1) {
                    result += end - start + 1;
                }
            } else {
                start = i;
                end = i;
            }
        }
        return result;
    }
}