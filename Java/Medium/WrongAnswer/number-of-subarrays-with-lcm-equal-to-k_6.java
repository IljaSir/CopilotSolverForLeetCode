class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % k == 0) {
                dp[i + 1] = 1;
                res++;
            } else {
                for (int j = i; j >= 0; j--) {
                    if (dp[j] == 1) {
                        int gcd = gcd(nums[i], nums[j]);
                        if (gcd % k == 0) {
                            dp[i + 1] = 1;
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }
}