class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        long mod = 1000000007;
        long[] dp = new long[arr.length];
        Arrays.sort(arr);
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int index = Arrays.binarySearch(arr, arr[i] / arr[j]);
                    if (index >= 0) {
                        dp[i] = (dp[i] + dp[j] * dp[index]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (long l : dp) {
            ans = (ans + l) % mod;
        }
        return (int) ans;
    }
}