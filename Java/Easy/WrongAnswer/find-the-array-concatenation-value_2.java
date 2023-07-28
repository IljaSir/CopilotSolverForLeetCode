class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += (nums[i] + nums[n - i - 1]) * Math.pow(10, len(nums[n - i - 1])) + nums[n - i - 1];
        }
        if (n % 2 == 1) {
            ans += nums[n / 2];
        }
        return ans;
    }

    private int len(int x) {
        int ans = 0;
        while (x > 0) {
            ans++;
            x /= 10;
        }
        return ans;
    }
}