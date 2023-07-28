class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            res += dp[sum % 2];
            dp[sum % 2]++;
        }
        return res % 1000000007;
    }
}