class Solution {
    public int minimumOperations(int[] nums) {
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] % 2 == 0) {
                    res++;
                }
            } else {
                if (nums[i] % 2 == 1) {
                    res++;
                }
            }
        }
        return Math.min(res, nums.length - res);
    }
}