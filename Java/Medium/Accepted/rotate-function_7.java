class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int f0 = 0;
        for (int i = 0; i < n; i++) {
            f0 += i * nums[i];
            sum += nums[i];
        }
        int max = f0;
        for (int i = 1; i < n; i++) {
            int fi = f0 + sum - n * nums[n - i];
            max = Math.max(max, fi);
            f0 = fi;
        }
        return max;
    }
}