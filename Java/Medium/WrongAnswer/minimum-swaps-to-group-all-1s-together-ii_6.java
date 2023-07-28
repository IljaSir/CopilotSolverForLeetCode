class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
        }
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 1) {
                max++;
            }
        }
        int res = count - max;
        for (int i = count; i < n; i++) {
            if (nums[i - count] == 1) {
                max--;
            }
            if (nums[i] == 1) {
                max++;
            }
            res = Math.min(res, count - max);
        }
        return res;
    }
}