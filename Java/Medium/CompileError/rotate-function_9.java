class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
            sum += nums[i];
        }
        max = f;
        for (int i = n - 1; i > 0; i--) {
            f = f + sum - n * nums[i];
            max = Math.max(max, f
            max = Math.max(f, max);
        }
        return max;
    }
}