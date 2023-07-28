class Solution {
    public int getMaximumGenerated(int n) {
        
        if (n < 2) return n;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 1; i <= n / 2; i++) {
            nums[2 * i] = nums[i];
            if (2 * i + 1 <= n) nums[2 * i + 1] = nums[i] + nums[i + 1];
        }
        int max = -1;
        for (int num : nums) max = Math.max(max, num);
        return max;
    }
}