class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int res = 0;
        int n = nums.length;
        int[] dp = new int[k];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[k];
            temp[nums[i] % k]++;
            for (int j = 0; j < k; j++) {
                if (dp[j] > 0) {
                    int gcd = gcd(nums[i] % k, j);
                    temp[gcd]++;
                }
            }
            for (int j = 0; j < k; j++) {
                dp[j] += temp[j];
            }
            if (dp[0] > 0) {
                res++;
            }
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}