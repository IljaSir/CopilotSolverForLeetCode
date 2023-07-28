class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(arr[i], i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    int k = arr[i] / arr[j];
                    if (map.containsKey(k)) {
                        dp[i] += dp[j] * dp[map.get(k)];
                        dp[i] %= 1000000007;
                    }
                }
            }
            ans += dp[i];
            ans %= 1000000007;
        }
        return (int)ans;
    }
}