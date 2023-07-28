class Solution {
    public int getMaximumGenerated(int n) {
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i / 2];
            if (i % 2 == 1) {
                nums[i] += nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}