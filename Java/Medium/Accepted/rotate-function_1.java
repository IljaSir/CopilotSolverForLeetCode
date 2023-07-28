class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int ans = f;
        for (int i = n - 1; i >= 1; i--) {
            f += sum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}