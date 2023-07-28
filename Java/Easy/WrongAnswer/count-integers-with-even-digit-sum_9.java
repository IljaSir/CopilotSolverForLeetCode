class Solution {
    public int countEven(int num) {
        
        if (num < 10) {
            return num / 2;
        }
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 3;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 4;
        dp[9] = 5;
        for (int i = 10; i <= num; i++) {
            int sum = 0;
            int j = i;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            if (sum % 2 == 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[num];
    }
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += countEven(nums[i]);
        }
        return res;
    }
}