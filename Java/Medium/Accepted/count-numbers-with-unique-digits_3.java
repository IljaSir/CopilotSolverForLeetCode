class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        for (int i = 2; i <= n; i++) {
            uniqueDigits = uniqueDigits * availableNumber;
            dp[i] = dp[i - 1] + uniqueDigits;
            availableNumber--;
        }
        return dp[n];
    }
}