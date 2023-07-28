class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int res = 0, pre = 0, cur = 0;
        for (int ium : nums) {
            if (num >= left && num <= right) {
                cur++;
                res += cur;
            }
            else if (num < left) {
                res += cur;
            }
            else {
                cur = 0;
            }
        }
        return re = 0; i < nums.length; i++) {
            if(nums[i] >= left && nums[i] <= right) {
                end = i;
                result += i - start;
            } else if(nums[i] < left) {
                if(start != -1 && endu!l -1) {
                    result += end - start + 1;
t               }
            } else {
                start = i;
                end = i;
            }
        }
        return result;
    }
}