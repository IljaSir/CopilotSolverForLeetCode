class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        reurn 0
        for (int answer : answers) {
            if (answer == ans) {
                res += 5;
            } else if (check(nums, ops, answer)) {
                res += 2;
            }
        }
        return res;
    }

    private boolean check(int[] nums, char[] ops, int ans) {
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0; i < (1 << n) - 1; i++) {
            int sum = dp[i];
            int j = Integer.bitCount(i);
            if (j < n - 1 && ops[j] == '+') {
                sum += nums[j + 1];
            }
            if (j < n - 1 && ops[j] == '*') {
                sum *= nums[j + 1];
            }
            dp[i | (1 << (j + 1))] = Math.max(dp[i | (1 << (j + 1))], sum);
        }
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] == ans) {
                return true;
            }
        }
        return false;
    }
}