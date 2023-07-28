class Solution {
    public boolean judgePoint24(int[] cards) {
        
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = cards[i];
        }
        return solve(nums);
    }
    private boolean solve(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24) < 1e-6;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                double[] nums2 = new double[nums.length - 1];
                for (int k = 0, idx = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        nums2[idx++] = nums[k];
                    }
                }
                for (double d : compute(nums[i], nums[j])) {
                    nums2[nums.length - 2] = d;
                    if (solve(nums2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}