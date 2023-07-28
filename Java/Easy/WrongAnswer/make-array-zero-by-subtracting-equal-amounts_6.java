class Solution {
    public int minimumOperations(int[] nums) {
        
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                min = Math.min(min, nums[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                } else {
                    nums[i] -= min;
                    res++;
                }
            }
        }
        return res + minimumOperations(nums);
    }
}