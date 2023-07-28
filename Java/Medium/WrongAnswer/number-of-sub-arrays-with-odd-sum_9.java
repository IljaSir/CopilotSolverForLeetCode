class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int[] dp = new int[2];
        dp[0] = 1;
        int s = 0;
        int r = 0;
        for (int i : arr) {
            s += i;
            r = (r + dp[s % 2]) % 1000000007;
            dp[s % 2]++;
        }
        return r;
    }
}